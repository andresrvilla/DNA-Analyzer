package com.dna_analyzer.mocks;

import com.dna_analyzer.interfaces.search.IBooleanSearch;

public class BooleanSearchMock implements IBooleanSearch {

    public Boolean Searched = false;

    @Override
    public boolean BooleanSearch(String[] dna, String sequence) {
        Searched = true;
        return true;
    }
}
