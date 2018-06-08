package com.dna_analyzer.services.analysis;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.exceptions.InvalidBaseElementInDNA;
import com.dna_analyzer.exceptions.InvalidDNASizeException;
import com.dna_analyzer.mocks.DNADataMock;
import com.dna_analyzer.models.DNA;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DNAAnalyzerStatsTest {

    @Test
    void processDNADataShouldInsertDNAInDataSource() throws DNADataException, InvalidDNASizeException, InvalidBaseElementInDNA, ClassNotFoundException {
        DNADataMock iDnaDataMock = new DNADataMock();
        DNAAnalyzerStats dnaAnalyzerStats = new DNAAnalyzerStats(iDnaDataMock);
        String[] dnaMock = {"AA", "TT"};
        ArrayList<String> statsConfigurationMock = new ArrayList<String>();
        dnaAnalyzerStats.ProcessDNAData(new DNA(dnaMock), statsConfigurationMock);
        assertTrue(iDnaDataMock.inserted);
    }

    @Test
    void getStatsShouldReturnValuesFromDataSource() throws DNADataException, ClassNotFoundException {
        DNADataMock iDnaDataMock = new DNADataMock();
        DNAAnalyzerStats dnaAnalyzerStats = new DNAAnalyzerStats(iDnaDataMock);
        assertEquals(dnaAnalyzerStats.getStats().size(), 3);
        Iterator it = dnaAnalyzerStats.getStats().entrySet().iterator();
        Map.Entry<String, Long> pair = (Map.Entry) it.next();
        assertEquals(pair.getValue().longValue(), 1.0);
        pair = (Map.Entry) it.next();
        assertEquals(pair.getValue().longValue(), 2.0);
        pair = (Map.Entry) it.next();
        assertEquals(pair.getValue().longValue(), 3.0);
    }

}