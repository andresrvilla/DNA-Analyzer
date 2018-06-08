package com.dna_analyzer.mocks;

import com.dna_analyzer.models.DNA;
import com.dna_analyzer.services.analysis.IDNAAnalyzerStats;

import java.util.ArrayList;
import java.util.HashMap;

public class DNAAnalyzerStatsMock implements IDNAAnalyzerStats {
    boolean processed = true;
    HashMap<String, Long> stats;

    public DNAAnalyzerStatsMock(HashMap<String, Long> stats) {
        this.stats = stats;
    }

    @Override
    public void ProcessDNAData(DNA dna, ArrayList<String> statsConfiguration) {
        this.processed = true;
    }

    @Override
    public HashMap<String, Long> getStats() {

        return stats;
    }
}
