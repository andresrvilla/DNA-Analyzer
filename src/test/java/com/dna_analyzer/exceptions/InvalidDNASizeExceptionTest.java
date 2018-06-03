package com.dna_analyzer.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidDNASizeExceptionTest {

    @Test
    void CreateObjectShoudReturnCorrectMessage() {
        InvalidDNASizeException exception = new InvalidDNASizeException();
        assertEquals(exception.getMessage(), "El tamaño del adn es inválido. Debe ser de NxN");
    }

}