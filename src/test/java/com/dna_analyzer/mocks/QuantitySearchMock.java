package com.dna_analyzer.mocks;

import com.dna_analyzer.interfaces.search.IQuantitySearch;

public class QuantitySearchMock implements IQuantitySearch {

    public Boolean Searched = false;

    public int QuantitySearch(String[] dna, String sequence) {
        Searched = true;
        return -99;
    }
}
