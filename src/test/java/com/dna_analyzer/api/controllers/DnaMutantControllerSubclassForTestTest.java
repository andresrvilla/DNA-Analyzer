package com.dna_analyzer.api.controllers;

import com.dna_analyzer.api.request.MutantRequest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DnaMutantControllerSubclassForTestTest {

    @Test
    void DnaMutantControllerShouldResponseWithOkWhenIsMutant() throws SQLException, ClassNotFoundException, IOException {
        DnaMutantControllerSubclassForTest controller = new DnaMutantControllerSubclassForTest();
        MutantRequest request = new MutantRequest();
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        request.setDna(dna);
        Response response = controller.IsMutant(request);
        assertEquals(response.getStatus(), 200);
    }

    @Test
    void DnaMutantControllerShouldResponseWithForbidenWhenNotIsMutant() throws SQLException, ClassNotFoundException, IOException {
        DnaMutantControllerSubclassForTest controller = new DnaMutantControllerSubclassForTest();
        controller.InitializeDependenciesForNegative();
        MutantRequest request = new MutantRequest();
        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        request.setDna(dna);
        Response response = controller.IsMutant(request);
        assertEquals(response.getStatus(), 403);
    }

    @Test
    void DnaMutantControllerShouldResponseWithErrorWhenNotIsInvalidDNA() throws SQLException, ClassNotFoundException, IOException {
        DnaMutantControllerSubclassForTest controller = new DnaMutantControllerSubclassForTest();
        controller.InitializeDependenciesForNegative();
        MutantRequest request = new MutantRequest();
        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "ACGG", "GCGTCA", "TCACTG"};
        request.setDna(dna);
        Response response = controller.IsMutant(request);
        assertEquals(response.getStatus(), 500);
    }

}