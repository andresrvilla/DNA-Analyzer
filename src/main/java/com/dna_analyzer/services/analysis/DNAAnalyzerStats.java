package com.dna_analyzer.services.analysis;

import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.data.interfaces.IDNAData;
import com.dna_analyzer.models.DNA;

import java.util.ArrayList;
import java.util.HashMap;

public class DNAAnalyzerStats implements IDNAAnalyzerStats {
    IDNAData idnaData;

    public DNAAnalyzerStats(IDNAData idnaData) {
        this.idnaData = idnaData;
    }

    @Override
    public void ProcessDNAData(DNA dna, ArrayList<String> statsConfiguration) throws DNADataException, ClassNotFoundException {
        idnaData.InsertDNA(dna.toString(), statsConfiguration);
    }

    @Override
    public HashMap<String, Long> getStats() throws DNADataException, ClassNotFoundException {
        return idnaData.GetStats();
    }
}
