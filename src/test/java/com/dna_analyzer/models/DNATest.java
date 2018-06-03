package com.dna_analyzer.models;

import com.dna_analyzer.exceptions.InvalidDNASizeException;
import com.dna_analyzer.mocks.SecuenceQuantitySearchMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DNATest {
    @Test
    void ConstructorShouldCreateObjectSuccessfully() throws InvalidDNASizeException {
        String[] dna = {"AA", "TT"};
        SecuenceQuantitySearchMock secuenceQuantitySearchMock = new SecuenceQuantitySearchMock();
        DNA Dna = new DNA(dna, secuenceQuantitySearchMock);
        assertEquals(Dna.SequenceQuantitySearch("XX"), -99);
        assertTrue(secuenceQuantitySearchMock.Searched);
    }
}