package com.dna_analyzer.mocks;

import com.dna_analyzer.data.interfaces.IDNAData;

import java.util.ArrayList;
import java.util.HashMap;

public class DNADataMock implements IDNAData {

    private static final HashMap<String, Long> mockData;

    static {
        mockData = new HashMap<String, Long>();
        mockData.put("Stats1", (long) 1.0);
        mockData.put("Stats2", (long) 2.0);
        mockData.put("Stats3", (long) 3.0);
    }

    public boolean inserted = false;

    @Override
    public HashMap<String, Long> GetStats() {
        return mockData;
    }

    @Override
    public void InsertDNA(String dna, ArrayList<String> statsnames) {
        this.inserted = true;
    }
}
