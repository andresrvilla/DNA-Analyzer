package com.dna_analyzer.data.providers.mariadb;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.mocks.DBHelperMock;
import com.dna_analyzer.mocks.DBHelperWithExceptionMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MariaDBDataTest {

    @Test
    void getStatsShouldReturnConfiguredMockData() throws ClassNotFoundException, DNADataException {
        DBHelperMock idbHelper = new DBHelperMock();
        MariaDBData dbData = new MariaDBData(idbHelper);
        HashMap<String, Long> stats = dbData.GetStats();
        Iterator it = stats.entrySet().iterator();
        Map.Entry<String, Long> pair = (Map.Entry) it.next();
        assertEquals(pair.getKey(), "mockdata");
        assertEquals(pair.getValue().longValue(), (long) 9999);
        assertTrue(idbHelper.executedQuery);
    }

    @Test
    void getStatsWithForcedErrorShouldThrowException() {
        DBHelperWithExceptionMock idbHelper = new DBHelperWithExceptionMock();
        MariaDBData dbData = new MariaDBData(idbHelper);
        Assertions.assertThrows(DNADataException.class, () -> {
            HashMap<String, Long> stats = dbData.GetStats();
        });
    }

    @Test
    void insertDNAShouldCallHelperMethodsToExecuteQuery() throws ClassNotFoundException, DNADataException {
        DBHelperMock idbHelper = new DBHelperMock();
        MariaDBData dbData = new MariaDBData(idbHelper);
        String[] dnaMock = {"AA", "TT"};
        ArrayList<String> statesMock = new ArrayList<>();
        statesMock.add("mock");
        dbData.InsertDNA("AAAA-AAAA-AAAA-AAA", statesMock);
        assertTrue(idbHelper.executedQuery);
        assertTrue(idbHelper.executedBatch);
    }

    @Test
    void insertDNAWithException() {
        DBHelperWithExceptionMock idbHelper = new DBHelperWithExceptionMock();
        MariaDBData dbData = new MariaDBData(idbHelper);
        String[] dnaMock = {"AA", "TT"};
        ArrayList<String> statesMock = new ArrayList<>();
        statesMock.add("mock");
        Assertions.assertThrows(DNADataException.class, () -> {
            dbData.InsertDNA("AAAA-AAAA-AAAA-AAA", statesMock);
        });

    }
}