package com.dna_analyzer.mocks;

import com.dna_analyzer.interfaces.search.ISecuenceQuantitySearch;

public class SecuenceQuantitySearchMock implements ISecuenceQuantitySearch {

    public Boolean Searched = false;

    public int QuantitySearch(String[] dna, String sequence) {
        Searched = true;
        return -99;
    }
}
