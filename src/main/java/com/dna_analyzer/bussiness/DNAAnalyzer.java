package com.dna_analyzer.bussiness;

import com.dna_analyzer.bussiness.search.AllDirectionsSequenceQuantitySearch;
import com.dna_analyzer.exceptions.InvalidDNASizeException;
import com.dna_analyzer.models.DNA;

public class DNAAnalyzer {

    public static boolean isMutant(String[] dna) throws InvalidDNASizeException {
        AllDirectionsSequenceQuantitySearch allDirectionsSequenceQuantitySearch = new AllDirectionsSequenceQuantitySearch();
        DNA Dna = new DNA(dna, allDirectionsSequenceQuantitySearch);

        String[] sequencesToFind = {"AAAA", "TTTT", "CCCC", "GGGG"};
        int times = 0;
        for (int i = 0; i < sequencesToFind.length; i++) {
            times += Dna.SequenceQuantitySearch(sequencesToFind[i]);
        }
        return times >= 2;
    }
}
