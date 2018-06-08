package com.dna_analyzer.services.analysis;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.data.interfaces.IDNAData;
import com.dna_analyzer.exceptions.InvalidBaseElementInDNA;
import com.dna_analyzer.exceptions.InvalidDNASizeException;
import com.dna_analyzer.interfaces.search.IQuantitySearch;
import com.dna_analyzer.mocks.DNAAnalyzerStatsMock;
import com.dna_analyzer.mocks.DNADataMock;
import com.dna_analyzer.models.DNA;
import com.dna_analyzer.services.DNAMagnetoBussiness;
import com.dna_analyzer.services.search.AllDirectionsSequenceQuantitySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DNAMagnetoAnalyzerIntegratedTest {


    private DNAMagnetoBussiness getDnaMagnetoAnalyzer() {
        IDNAData dnaDataMock = new DNADataMock();
        IQuantitySearch secuenceQuantitySearch = new AllDirectionsSequenceQuantitySearch();
        IDNAAnalyzer dnaAnalyzerMock = new DNAAnalyzer(secuenceQuantitySearch);
        IDNAAnalyzerStats dnaAnalyzerStatsMock = new DNAAnalyzerStatsMock(new HashMap<String, Long>());

        return new DNAMagnetoBussiness(dnaDataMock, dnaAnalyzerMock, dnaAnalyzerStatsMock);
    }

    @Test
    void IsMutantShouldReturnTrueMeliInstructionsExample() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        //Test positivo que se encuentra en el enunciado
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }


    @Test
    void IsMutantShouldReturnFalseMeliInstructionsExample() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        //Test negativo que se encuentra en el enunciado
        assertFalse(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturn6x6TrueAscendentVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGAGA", "CAATGC", "TAATTT", "AGACTG", "GCGTCA", "TCTCTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6DescendentVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGAGA", "CATGGC", "TTATGT", "ATACTG", "GCTTCA", "TCTTTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6DescendentAndAscendantVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGTGA", "CATGGC", "TTATGT", "TTACTG", "GCATCA", "TCTTTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue7X7DescendentAndAscendantVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGTGAA", "CATGGCC", "TTATGTT", "TTACTGG", "GCATCAA", "TCTTTGG", "ATCCATA"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6HorizontalAndDescendentVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGCGA", "CAGTAC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6VerticalAndDescendentVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CACCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6HorizontalAndAscendantVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"ATGAGA", "CAATAC", "TATTGT", "AGAGAG", "CCCCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6VerticalAndAscendantVerticalCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"CTGCGA", "CCGAGC", "TTATGT", "TAATGG", "AACCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnFalse6x6VerticalOnlyCase() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"CTGCGA", "CCGAGC", "TTATGT", "TCATGG", "AACCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertFalse(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6VerticalOnLimits() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"CTGCAG", "CCGACG", "CTATTG", "CCATGG", "AACCTA", "TCACTG"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldReturnTrue6x6HorizontalOnLimits() throws InvalidDNASizeException, DNADataException, ClassNotFoundException, InvalidBaseElementInDNA {
        String[] dna = {"CCCCAG", "CCGACC", "TTATTT", "TCATGG", "AACCTA", "TCAAAA"};
        DNAMagnetoBussiness magnetoAnalyzer = getDnaMagnetoAnalyzer();
        assertTrue(magnetoAnalyzer.isMutant(new DNA(dna)));
    }

    @Test
    void IsMutantShouldThrowExceptionOnInvalidArraySize() {
        String[] dna = {"CCCCAG", "CCGACC", "TTATTT", "TCATGG", "AACCTA"};
        Assertions.assertThrows(InvalidDNASizeException.class, () -> {
            getDnaMagnetoAnalyzer().isMutant(new DNA(dna));
        });
    }

    @Test
    void IsMutantShouldThrowExceptionOnInvalidLineSize() {
        String[] dna = {"CCCCAG", "CCGACC", "TTATTT", "TCAGG", "AACCTA", "TCAAAA"};
        Assertions.assertThrows(InvalidDNASizeException.class, () -> {
            getDnaMagnetoAnalyzer().isMutant(new DNA(dna));
        });
    }

}