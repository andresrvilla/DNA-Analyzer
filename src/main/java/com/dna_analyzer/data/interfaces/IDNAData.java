package com.dna_analyzer.data.interfaces;

import com.dna_analyzer.data.exceptions.DNADataException;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDNAData {
    HashMap<String, Long> GetStats() throws DNADataException, ClassNotFoundException;

    void InsertDNA(String dna, ArrayList<String> statsnames) throws DNADataException, ClassNotFoundException;
}
