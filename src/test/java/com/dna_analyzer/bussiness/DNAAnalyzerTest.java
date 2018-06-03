package com.dna_analyzer.bussiness;

import com.dna_analyzer.exceptions.InvalidDNASizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DNAAnalyzerTest {

    @Test
    void IsMutantShouldReturnTrueMeliInstructionsExample() throws InvalidDNASizeException {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        //Test positivo que se encuentra en el enunciado
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnFalseMeliInstructionsExample() throws InvalidDNASizeException {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        //Test negativo que se encuentra en el enunciado
        assertFalse(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturn6x6TrueAscendentVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGAGA", "CAATGC", "TAATTT", "AGACTG", "GCGTCA", "TCTCTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6DescendentVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGAGA", "CATGGC", "TTATGT", "ATACTG", "GCTTCA", "TCTTTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6DescendentAndAscendantVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGTGA", "CATGGC", "TTATGT", "TTACTG", "GCATCA", "TCTTTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue7X7DescendentAndAscendantVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGTGAA", "CATGGCC", "TTATGTT", "TTACTGG", "GCATCAA", "TCTTTGG", "ATCCATA"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6HorizontalAndDescendentVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGCGA", "CAGTAC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6VerticalAndDescendentVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CACCTA", "TCACTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6HorizontalAndAscendantVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"ATGAGA", "CAATAC", "TATTGT", "AGAGAG", "CCCCTA", "TCACTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6VerticalAndAscendantVerticalCase() throws InvalidDNASizeException {
        String[] dna = {"CTGCGA", "CCGAGC", "TTATGT", "TAATGG", "AACCTA", "TCACTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnFalse6x6VerticalOnlyCase() throws InvalidDNASizeException {
        String[] dna = {"CTGCGA", "CCGAGC", "TTATGT", "TCATGG", "AACCTA", "TCACTG"};
        assertFalse(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6VerticalOnLimits() throws InvalidDNASizeException {
        String[] dna = {"CTGCAG", "CCGACG", "CTATTG", "CCATGG", "AACCTA", "TCACTG"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldReturnTrue6x6HorizontalOnLimits() throws InvalidDNASizeException {
        String[] dna = {"CCCCAG", "CCGACC", "TTATTT", "TCATGG", "AACCTA", "TCAAAA"};
        assertTrue(DNAAnalyzer.isMutant(dna));
    }

    @Test
    void IsMutantShouldThrowExceptionOnInvalidArraySize() {
        String[] dna = {"CCCCAG", "CCGACC", "TTATTT", "TCATGG", "AACCTA"};
        Assertions.assertThrows(InvalidDNASizeException.class, () -> {
            DNAAnalyzer.isMutant(dna);
        });
    }

    @Test
    void IsMutantShouldThrowExceptionOnInvalidLineSize() {
        String[] dna = {"CCCCAG", "CCGACC", "TTATTT", "TCAGG", "AACCTA", "TCAAAA"};
        Assertions.assertThrows(InvalidDNASizeException.class, () -> {
            DNAAnalyzer.isMutant(dna);
        });
    }

}