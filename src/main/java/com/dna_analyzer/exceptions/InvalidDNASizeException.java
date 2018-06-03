package com.dna_analyzer.exceptions;

public class InvalidDNASizeException extends Exception {
    public InvalidDNASizeException() {
        super("El tamaño del adn es inválido. Debe ser de NxN");
    }
}
