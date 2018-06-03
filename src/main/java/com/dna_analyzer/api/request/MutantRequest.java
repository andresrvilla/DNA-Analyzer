package com.dna_analyzer.api.request;

public class MutantRequest {
    String[] dna;

    public MutantRequest() {
    }

    public MutantRequest(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return this.dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
