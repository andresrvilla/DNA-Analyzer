package com.dna_analyzer.models;

import com.dna_analyzer.exceptions.InvalidBaseElementInDNA;
import com.dna_analyzer.exceptions.InvalidDNASizeException;

public class DNA {
    private String[] dna;
    private String dnaElementsRegex = "[ACGT]+";

    public DNA(String[] dna) throws InvalidDNASizeException, InvalidBaseElementInDNA {
        if (dna == null || dna.length == 0 || dna.length != dna[0].length())
            throw new InvalidDNASizeException();

        //recorro empezando en 1 porque en la validación anterior ya verifiqué
        //que el length del primer elemento es igual al length del array
        for (int i = 1; i < dna.length; i++) {
            if (dna[i].length() != dna[0].length())
                throw new InvalidDNASizeException();
        }
        for (int i = 0; i < dna.length; i++) {
            if (!dna[i].matches(dnaElementsRegex))
                throw new InvalidBaseElementInDNA();
        }

        this.dna = dna;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < dna.length; i++) {
            result += dna[i] + "-";
        }
        return result.substring(0, result.length() - 1);
    }

    public String[] getDna() {
        return dna;
    }
}
