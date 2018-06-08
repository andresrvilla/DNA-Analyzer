package com.dna_analyzer.mocks;

import com.dna_analyzer.interfaces.search.IElementsSearch;

public class ElementsSearchMock implements IElementsSearch {

    public Boolean Searched = false;

    @Override
    public String[] ElementsSearch(String[] dna, String sequence) {
        Searched = true;
        return new String[]{"A", "B"};
    }
}
