package com.dna_analyzer.api.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void setMessageShouldSetMessageInObject() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Unit Test");
        assertEquals(errorResponse.message, "Unit Test");
    }

    @Test
    void getMessageShouldReturnConfiguredMessageFromObject() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Unit Test");
        assertEquals(errorResponse.getMessage(), "Unit Test");
    }
}