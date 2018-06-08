package com.dna_analyzer.services;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.mocks.DNAAnalyzerMock;
import com.dna_analyzer.mocks.DNAAnalyzerStatsMock;
import com.dna_analyzer.mocks.DNADataMock;
import com.dna_analyzer.mocks.QuantitySearchMock;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DNAMagnetoBussinessTest {

    @Test
    void threeStatsShouldReturnJsonWithBothValuesAndRatio() throws ClassNotFoundException, DNADataException, JSONException {

        DNADataMock dnaDataMock = new DNADataMock();
        QuantitySearchMock secuenceQuantitySearch = new QuantitySearchMock();
        DNAAnalyzerMock dnaAnalyzerMock = new DNAAnalyzerMock(secuenceQuantitySearch);
        HashMap<String, Long> stats = new HashMap<String, Long>();
        stats.put("valor1", new Long(1));
        stats.put("valor2", new Long(2));
        stats.put("valor3", new Long(3));
        DNAAnalyzerStatsMock dnaAnalyzerStatsMock = new DNAAnalyzerStatsMock(stats);


        DNAMagnetoBussiness dnaMagnetoBussiness = new DNAMagnetoBussiness(dnaDataMock, dnaAnalyzerMock, dnaAnalyzerStatsMock);
        JSONObject result = dnaMagnetoBussiness.stats();
        assertEquals(result.get("valor1"), (long) 1);
        assertEquals(result.get("valor2"), (long) 2);
        assertEquals(result.get("valor3"), (long) 3);
        assertEquals(result.get("ratio"), "1.0:3.0:2.0");
    }

    @Test
    void twoStatsShouldReturnJsonWithBothValuesAndRatio() throws ClassNotFoundException, DNADataException, JSONException {

        DNADataMock dnaDataMock = new DNADataMock();
        QuantitySearchMock secuenceQuantitySearch = new QuantitySearchMock();
        DNAAnalyzerMock dnaAnalyzerMock = new DNAAnalyzerMock(secuenceQuantitySearch);
        HashMap<String, Long> stats = new HashMap<String, Long>();
        stats.put("count_mutant_dna", new Long(1));
        stats.put("count_human_dna", new Long(2));
        DNAAnalyzerStatsMock dnaAnalyzerStatsMock = new DNAAnalyzerStatsMock(stats);


        DNAMagnetoBussiness dnaMagnetoBussiness = new DNAMagnetoBussiness(dnaDataMock, dnaAnalyzerMock, dnaAnalyzerStatsMock);
        JSONObject result = dnaMagnetoBussiness.stats();
        assertEquals(result.get("count_mutant_dna"), (long) 1);
        assertEquals(result.get("count_human_dna"), (long) 2);
        assertEquals(result.get("ratio"), 0.5);
    }

    @Test
    void oneStatShouldReturnJsonWithSingleValueAndRatio() throws ClassNotFoundException, DNADataException, JSONException {

        DNADataMock dnaDataMock = new DNADataMock();
        QuantitySearchMock secuenceQuantitySearch = new QuantitySearchMock();
        DNAAnalyzerMock dnaAnalyzerMock = new DNAAnalyzerMock(secuenceQuantitySearch);
        HashMap<String, Long> stats = new HashMap<String, Long>();
        stats.put("valor1", new Long(1));
        DNAAnalyzerStatsMock dnaAnalyzerStatsMock = new DNAAnalyzerStatsMock(stats);
        DNAMagnetoBussiness dnaMagnetoBussiness = new DNAMagnetoBussiness(dnaDataMock, dnaAnalyzerMock, dnaAnalyzerStatsMock);
        JSONObject result = dnaMagnetoBussiness.stats();
        assertEquals(result.get("valor1"), (long) 1);
        assertEquals(result.get("ratio"), "1.0");
    }

    @Test
    void oneStatZeroValueShouldReturnJsonWithSingleValueAndRatio() throws ClassNotFoundException, DNADataException, JSONException {

        DNADataMock dnaDataMock = new DNADataMock();
        QuantitySearchMock secuenceQuantitySearch = new QuantitySearchMock();
        DNAAnalyzerMock dnaAnalyzerMock = new DNAAnalyzerMock(secuenceQuantitySearch);
        HashMap<String, Long> stats = new HashMap<String, Long>();
        stats.put("valor1", new Long(0));
        DNAAnalyzerStatsMock dnaAnalyzerStatsMock = new DNAAnalyzerStatsMock(stats);
        DNAMagnetoBussiness dnaMagnetoBussiness = new DNAMagnetoBussiness(dnaDataMock, dnaAnalyzerMock, dnaAnalyzerStatsMock);
        JSONObject result = dnaMagnetoBussiness.stats();
        assertEquals(result.get("valor1"), (long) 0);
        assertEquals(result.get("ratio"), "undefined");
    }
}