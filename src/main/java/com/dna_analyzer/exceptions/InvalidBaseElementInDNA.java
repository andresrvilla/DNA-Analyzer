package com.dna_analyzer.exceptions;

public class InvalidBaseElementInDNA extends Exception {
    public InvalidBaseElementInDNA() {
        super("El ADN Contiene valores inválidos de bases nitrogenadas");
    }
}
