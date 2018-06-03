package com.dna_analyzer.models;

import com.dna_analyzer.exceptions.InvalidDNASizeException;
import com.dna_analyzer.interfaces.search.ISecuenceQuantitySearch;

public class DNA {
    private String[] dna;
    private ISecuenceQuantitySearch iSecuenceQuantitySearch;

    public DNA(String[] dna, ISecuenceQuantitySearch iSecuenceQuantitySearch) throws InvalidDNASizeException {
        if (dna == null || dna.length == 0 || dna.length != dna[0].length())
            throw new InvalidDNASizeException();

        //recorro empezando en 1 porque en la validación anterior ya verifiqué
        //que el length del primer elemento es igual al length del array
        for (int i = 1; i < dna.length; i++) {
            if (dna[i].length() != dna[0].length())
                throw new InvalidDNASizeException();
        }
        this.dna = dna;
        this.iSecuenceQuantitySearch = iSecuenceQuantitySearch;
    }

    public int SequenceQuantitySearch(String sequence) {
        return iSecuenceQuantitySearch.QuantitySearch(this.dna, sequence);
    }
}
