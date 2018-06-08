package com.dna_analyzer.services.analysis;

import com.dna_analyzer.models.DNA;

public interface IDNAAnalyzer {
    int QuantitySearch(DNA dnaToAnalyze, String sequence);

    boolean BooleanSearch(DNA dnaToAnalyze, String sequence);

    String[] ElementsSearch(DNA dnaToAnalyze, String sequence);
}
