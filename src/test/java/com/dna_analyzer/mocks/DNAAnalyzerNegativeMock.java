package com.dna_analyzer.mocks;

import com.dna_analyzer.interfaces.search.IQuantitySearch;
import com.dna_analyzer.models.DNA;
import com.dna_analyzer.services.analysis.IDNAAnalyzer;

public class DNAAnalyzerNegativeMock implements IDNAAnalyzer {

    IQuantitySearch iQuantitySearch;

    public DNAAnalyzerNegativeMock(IQuantitySearch iQuantitySearch) {
        this.iQuantitySearch = iQuantitySearch;
    }

    @Override
    public int QuantitySearch(DNA dnaToAnalyze, String sequence) {
        return 0;
    }

    @Override
    public boolean BooleanSearch(DNA dnaToAnalyze, String sequence) {
        return false;
    }

    @Override
    public String[] ElementsSearch(DNA dnaToAnalyze, String sequence) {
        return new String[0];
    }
}
