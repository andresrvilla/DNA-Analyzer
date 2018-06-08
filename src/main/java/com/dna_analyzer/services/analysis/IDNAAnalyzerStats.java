package com.dna_analyzer.services.analysis;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.models.DNA;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDNAAnalyzerStats {
    void ProcessDNAData(DNA dna, ArrayList<String> statsConfiguration) throws DNADataException, ClassNotFoundException;

    HashMap<String, Long> getStats() throws DNADataException, ClassNotFoundException;
}
