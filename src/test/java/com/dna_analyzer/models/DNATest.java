package com.dna_analyzer.models;

import com.dna_analyzer.exceptions.InvalidBaseElementInDNA;
import com.dna_analyzer.exceptions.InvalidDNASizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DNATest {
    @Test
    void ConstructorShouldCreateObjectSuccessfully() throws InvalidDNASizeException, InvalidBaseElementInDNA {
        String[] dna = {"AA", "TT"};
        DNA Dna = new DNA(dna);
        assertEquals(Dna.getDna(), dna);
    }

    @Test
    void DNAToStringMustReturnFormattedValue() throws InvalidDNASizeException, InvalidBaseElementInDNA {
        String[] dna = {"AAAA", "GGGT", "AAAA", "GGGT"};
        DNA Dna = new DNA(dna);
        assertEquals(Dna.toString(), "AAAA-GGGT-AAAA-GGGT");
    }

    @Test
    void DNAShouldThrowExceptionWhenAnElementIsInvalid() {
        String[] dna = {"AX", "TT"};
        Assertions.assertThrows(InvalidBaseElementInDNA.class, () -> {
            DNA Dna = new DNA(dna);
            assertEquals(Dna.getDna(), dna);
        });
    }

    @Test
    void DNAShouldThrowExceptionWhenAnElementHasWrongDimension() {
        String[] dna = {"A", "TT"};
        Assertions.assertThrows(InvalidDNASizeException.class, () -> {
            DNA Dna = new DNA(dna);
            assertEquals(Dna.getDna(), dna);
        });
    }
}