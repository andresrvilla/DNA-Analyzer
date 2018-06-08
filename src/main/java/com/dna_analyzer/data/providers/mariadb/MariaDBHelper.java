package com.dna_analyzer.data.providers.mariadb;

import com.dna_analyzer.data.exceptions.DNADataException;

import java.sql.*;

public class MariaDBHelper implements IDBHelper {

    private static Connection connection = null;
    private Statement batchStatement;
    private String jdbcConnectionString;
    private String username;
    private String password;

    public MariaDBHelper(String jdbcConnectionString, String username, String password) {

        this.jdbcConnectionString = jdbcConnectionString;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection(jdbcConnectionString, username, password);
        } else {
            if (connection.isClosed())
                connection = DriverManager.getConnection(jdbcConnectionString, username, password);
        }
        return connection;
    }

    public ResultSet executeQuery(String query) throws DNADataException, SQLException, ClassNotFoundException {
        if (getConnection() != null) {
            // create a Statement
            Statement stmt = getConnection().createStatement();
            //execute query
            return stmt.executeQuery(query);
        } else {
            throw new DNADataException("No existe conexión activa");
        }
    }

    public void prepareBatch() throws SQLException, ClassNotFoundException {
        batchStatement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    @Override
    public void addBatchStep(String batchStep) throws SQLException {
        if (batchStatement != null)
            batchStatement.addBatch(batchStep);
    }

    @Override
    public int[] executeBatch() throws SQLException {
        if (batchStatement != null)
            return batchStatement.executeBatch();
        else return new int[]{};
    }

}
