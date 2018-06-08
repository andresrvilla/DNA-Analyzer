package com.dna_analyzer.api.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MutantRequestTest {

    @Test
    void setDnaShouldSetDnaInObject() {
        MutantRequest mutantRequest = new MutantRequest();
        String[] dna = {"XX", "BB"};
        mutantRequest.setDna(dna);
        assertEquals(mutantRequest.dna, dna);
    }

    @Test
    void getDnaShouldReturnConfiguredDnaFromObject() {
        String[] dna = {"XX", "BB"};
        MutantRequest mutantRequest = new MutantRequest(dna);
        assertEquals(mutantRequest.getDna(), dna);
    }
}