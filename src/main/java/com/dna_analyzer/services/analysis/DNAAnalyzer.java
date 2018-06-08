package com.dna_analyzer.services.analysis;

import com.dna_analyzer.interfaces.search.IBooleanSearch;
import com.dna_analyzer.interfaces.search.IElementsSearch;
import com.dna_analyzer.interfaces.search.IQuantitySearch;
import com.dna_analyzer.models.DNA;

public class DNAAnalyzer implements IDNAAnalyzer {

    IQuantitySearch quantitySearch;
    IBooleanSearch booleanSearch;
    IElementsSearch elementsSearch;

    public DNAAnalyzer(IQuantitySearch quantitySearch) {
        this.quantitySearch = quantitySearch;
    }

    public DNAAnalyzer(IBooleanSearch booleanSearch) {
        this.booleanSearch = booleanSearch;
    }

    public DNAAnalyzer(IElementsSearch elementsSearch) {
        this.elementsSearch = elementsSearch;
    }

    @Override
    public int QuantitySearch(DNA dnaToAnalyze, String sequence) {
        return quantitySearch.QuantitySearch(dnaToAnalyze.getDna(), sequence);
    }

    @Override
    public boolean BooleanSearch(DNA dnaToAnalyze, String sequence) {
        return booleanSearch.BooleanSearch(dnaToAnalyze.getDna(), sequence);
    }

    @Override
    public String[] ElementsSearch(DNA dnaToAnalyze, String sequence) {
        return elementsSearch.ElementsSearch(dnaToAnalyze.getDna(), sequence);
    }
}
