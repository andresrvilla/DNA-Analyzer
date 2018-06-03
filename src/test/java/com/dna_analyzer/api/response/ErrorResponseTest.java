package com.dna_analyzer.api.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void setMessage() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Unit Test");
        assertEquals(errorResponse.message, "Unit Test");
    }

    @Test
    void getMessage() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Unit Test");
        assertEquals(errorResponse.getMessage(), "Unit Test");
    }
}