package com.dna_analyzer.api.controllers;

import com.dna_analyzer.mocks.*;
import com.dna_analyzer.services.DNAMagnetoBussiness;
import com.dna_analyzer.services.analysis.DNAAnalyzerStats;

import java.io.IOException;
import java.sql.SQLException;

public class DnaMutantControllerSubclassForTest extends DnaMutantController {
    public DnaMutantControllerSubclassForTest() throws SQLException, ClassNotFoundException, IOException {
        readConfig();
        InitializeDependencies();
    }

    @Override
    void InitializeDependencies() {
        mariaDBHelper = new DBHelperMock();
        idnaData = new DNADataMock();
        iQuantitySearch = new QuantitySearchMock();
        idnaAnalyzer = new DNAAnalyzerMock(iQuantitySearch);
        idnaAnalyzerStats = new DNAAnalyzerStats(idnaData);
        bussiness = new DNAMagnetoBussiness(idnaData, idnaAnalyzer, idnaAnalyzerStats);
    }

    void InitializeDependenciesForNegative() {
        mariaDBHelper = new DBHelperMock();
        idnaData = new DNADataMock();
        iQuantitySearch = new QuantitySearchMock();
        idnaAnalyzer = new DNAAnalyzerNegativeMock(iQuantitySearch);
        idnaAnalyzerStats = new DNAAnalyzerStats(idnaData);
        bussiness = new DNAMagnetoBussiness(idnaData, idnaAnalyzer, idnaAnalyzerStats);
    }
}
