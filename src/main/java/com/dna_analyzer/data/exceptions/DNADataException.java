package com.dna_analyzer.data.exceptions;

public class DNADataException extends Exception {
    public DNADataException() {
        super("Ha ocurrido un error al obtener los datos");
    }

    public DNADataException(String msg) {
        super(msg);
    }
}
