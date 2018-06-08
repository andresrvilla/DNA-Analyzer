package com.dna_analyzer.services.analysis;

import com.dna_analyzer.exceptions.InvalidBaseElementInDNA;
import com.dna_analyzer.exceptions.InvalidDNASizeException;
import com.dna_analyzer.interfaces.search.IBooleanSearch;
import com.dna_analyzer.interfaces.search.IElementsSearch;
import com.dna_analyzer.interfaces.search.IQuantitySearch;
import com.dna_analyzer.mocks.BooleanSearchMock;
import com.dna_analyzer.mocks.ElementsSearchMock;
import com.dna_analyzer.mocks.QuantitySearchMock;
import com.dna_analyzer.models.DNA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DNAAnalyzerTest {

    @Test
    void ConstructorWithQuantitySearchShouldSetPropertiesWithParameters() {
        IQuantitySearch quantitySearch = new QuantitySearchMock();
        DNAAnalyzer dnaAnalyzer = new DNAAnalyzer(quantitySearch);
        assertEquals(quantitySearch, dnaAnalyzer.quantitySearch);
    }

    @Test
    void quantitySearchShouldBeCalledOnSearch() throws InvalidDNASizeException, InvalidBaseElementInDNA {
        QuantitySearchMock secuenceQuantitySearch = new QuantitySearchMock();
        DNAAnalyzer dnaAnalyzer = new DNAAnalyzer(secuenceQuantitySearch);
        DNA dna = new DNA(new String[]{"GG", "AA"});
        dnaAnalyzer.QuantitySearch(dna, "GG");
        assertTrue(secuenceQuantitySearch.Searched);
    }

    @Test
    void ConstructorWithElementsSearchShouldSetPropertiesWithParameters() {
        IElementsSearch elementsSearch = new ElementsSearchMock();
        DNAAnalyzer dnaAnalyzer = new DNAAnalyzer(elementsSearch);
        assertEquals(elementsSearch, dnaAnalyzer.elementsSearch);
    }

    @Test
    void elementsSearchShouldBeCalledOnSearch() throws InvalidDNASizeException, InvalidBaseElementInDNA {
        ElementsSearchMock elementsSearch = new ElementsSearchMock();
        DNAAnalyzer dnaAnalyzer = new DNAAnalyzer(elementsSearch);
        DNA dna = new DNA(new String[]{"GG", "AA"});
        dnaAnalyzer.ElementsSearch(dna, "GG");
        assertTrue(elementsSearch.Searched);
    }

    @Test
    void ConstructorWithBooleanSearchShouldSetPropertiesWithParameters() {
        IBooleanSearch booleanSearch = new BooleanSearchMock();
        DNAAnalyzer dnaAnalyzer = new DNAAnalyzer(booleanSearch);
        assertEquals(booleanSearch, dnaAnalyzer.booleanSearch);
    }

    @Test
    void booleanSearchShouldBeCalledOnSearch() throws InvalidDNASizeException, InvalidBaseElementInDNA {
        BooleanSearchMock booleanSearch = new BooleanSearchMock();
        DNAAnalyzer dnaAnalyzer = new DNAAnalyzer(booleanSearch);
        DNA dna = new DNA(new String[]{"GG", "AA"});
        dnaAnalyzer.BooleanSearch(dna, "GG");
        assertTrue(booleanSearch.Searched);
    }
}