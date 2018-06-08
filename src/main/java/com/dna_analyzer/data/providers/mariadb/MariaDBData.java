package com.dna_analyzer.data.providers.mariadb;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.data.interfaces.IDNAData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MariaDBData implements IDNAData {

    IDBHelper dbHelper;

    public MariaDBData(IDBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public HashMap<String, Long> GetStats() throws DNADataException, ClassNotFoundException {
        HashMap<String, Long> result = new HashMap<String, Long>();
        try {
            ResultSet rs = dbHelper.executeQuery("SELECT name,value FROM stats");
            while (rs.next()) {
                result.put(rs.getString("name"), rs.getLong("value"));
            }
        } catch (SQLException e) {
            DNADataException exception = new DNADataException(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
        return result;
    }

    @Override
    public void InsertDNA(String dna, ArrayList<String> statsnames) throws DNADataException, ClassNotFoundException {

        try {
            //Verifico si ya fue insertado
            ResultSet rs = dbHelper.executeQuery("SELECT dnaanalyzer.insertdna('" + dna + "') as cantidad");
            //position result to first
            rs.next();
            if (rs.getBoolean("cantidad")) {
                dbHelper.prepareBatch();
                for (int i = 0; i < statsnames.size(); i++)
                    dbHelper.addBatchStep("CALL dnaanalyzer.incrementstats('" + statsnames.get(i) + "');");
                dbHelper.executeBatch();
            }


        } catch (SQLException e) {
            DNADataException exception = new DNADataException(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }
}
