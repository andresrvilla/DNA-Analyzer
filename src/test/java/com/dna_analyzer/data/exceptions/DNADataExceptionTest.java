package com.dna_analyzer.data.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DNADataExceptionTest {
    @Test
    void defaultConstructorShouldSetDefaultMessage() {
        DNADataException exception = new DNADataException();
        assertEquals(exception.getMessage(), "Ha ocurrido un error al obtener los datos");
    }

    @Test
    void stringParameterConstructorShouldSetCustomMessage() {
        DNADataException exception = new DNADataException("Mensaje custom para prueba");
        assertEquals(exception.getMessage(), "Mensaje custom para prueba");
    }
}