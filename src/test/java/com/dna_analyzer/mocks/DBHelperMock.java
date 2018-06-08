package com.dna_analyzer.mocks;

import com.dna_analyzer.data.ResultSetMock;
import com.dna_analyzer.data.providers.mariadb.IDBHelper;

import java.sql.ResultSet;

public class DBHelperMock implements IDBHelper {
    public boolean executedQuery;
    public boolean executedBatch;

    @Override
    public ResultSet executeQuery(String query) {
        executedQuery = true;
        return new ResultSetMock();
    }

    @Override
    public void prepareBatch() {

    }

    @Override
    public void addBatchStep(String batchStep) {

    }

    @Override
    public int[] executeBatch() {
        executedBatch = true;
        return new int[0];
    }
}
