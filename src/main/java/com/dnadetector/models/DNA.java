package com.dnadetector.models;

import com.dnadetector.exceptions.InvalidDNASizeException;
import com.dnadetector.interfaces.search.ISecuenceQuantitySearch;

public class DNA {
    private String[] dna;
    private ISecuenceQuantitySearch iSecuenceQuantitySearch;

    public DNA(String[] dna, ISecuenceQuantitySearch iSecuenceQuantitySearch) throws InvalidDNASizeException {
        if (dna == null || dna.length == 0 || dna.length != dna[0].length())
            throw new InvalidDNASizeException();
        this.dna = dna;
        this.iSecuenceQuantitySearch = iSecuenceQuantitySearch;
    }

    public int SequenceQuantitySearch(String sequence) {
        return iSecuenceQuantitySearch.QuantitySearch(this.dna, sequence);
    }
}
