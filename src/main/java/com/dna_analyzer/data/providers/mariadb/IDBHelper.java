package com.dna_analyzer.data.providers.mariadb;

import com.dna_analyzer.data.exceptions.DNADataException;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBHelper {

    ResultSet executeQuery(String query) throws DNADataException, SQLException, ClassNotFoundException;

    void prepareBatch() throws SQLException, ClassNotFoundException;

    void addBatchStep(String batchStep) throws SQLException;

    int[] executeBatch() throws SQLException;
}
