package com.dnadetector.mocks;

import com.dnadetector.interfaces.search.ISecuenceQuantitySearch;

public class SecuenceQuantitySearchMock implements ISecuenceQuantitySearch {

    public Boolean Searched = false;

    public int QuantitySearch(String[] dna, String sequence) {
        Searched = true;
        return -99;
    }
}
