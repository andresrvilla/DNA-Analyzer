package com.dna_analyzer.api.controllers;

import com.dna_analyzer.mocks.DBHelperMock;
import com.dna_analyzer.mocks.DNAAnalyzerMock;
import com.dna_analyzer.mocks.DNADataMock;
import com.dna_analyzer.mocks.QuantitySearchMock;
import com.dna_analyzer.services.DNAMagnetoBussiness;
import com.dna_analyzer.services.analysis.DNAAnalyzerStats;

import java.io.IOException;
import java.sql.SQLException;

public class DNAStatsControllerForTest extends DnaStatsController {
    public DNAStatsControllerForTest() throws SQLException, ClassNotFoundException, IOException {
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
}
