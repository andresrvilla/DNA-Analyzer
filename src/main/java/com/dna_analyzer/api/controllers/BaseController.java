package com.dna_analyzer.api.controllers;

import com.dna_analyzer.data.interfaces.IDNAData;
import com.dna_analyzer.data.providers.mariadb.IDBHelper;
import com.dna_analyzer.data.providers.mariadb.MariaDBData;
import com.dna_analyzer.data.providers.mariadb.MariaDBHelper;
import com.dna_analyzer.interfaces.search.IQuantitySearch;
import com.dna_analyzer.services.DNAMagnetoBussiness;
import com.dna_analyzer.services.analysis.DNAAnalyzer;
import com.dna_analyzer.services.analysis.DNAAnalyzerStats;
import com.dna_analyzer.services.analysis.IDNAAnalyzer;
import com.dna_analyzer.services.analysis.IDNAAnalyzerStats;
import com.dna_analyzer.services.search.AllDirectionsSequenceQuantitySearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseController {
    String connectionString = "";
    String userName = "";
    String password = "";

    IDBHelper mariaDBHelper;
    IDNAData idnaData;
    IQuantitySearch iQuantitySearch;
    IDNAAnalyzer idnaAnalyzer;
    IDNAAnalyzerStats idnaAnalyzerStats;
    DNAMagnetoBussiness bussiness;

    void readConfig() throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println("[INITIALIZACION] File not found: " + "property file '" + propFileName + "' not found in the classpath");
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            connectionString = prop.getProperty("connectionString");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
        } catch (Exception e) {
            System.out.println("[INITIALIZACION] Exception: " + e);
            throw e;
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
    }

    void InitializeDependencies() {
        /* Classes Construction  (Must change for IOC Container)*/
        mariaDBHelper = new MariaDBHelper(connectionString,
                userName,
                password);
        idnaData = new MariaDBData(mariaDBHelper);
        iQuantitySearch = new AllDirectionsSequenceQuantitySearch();
        idnaAnalyzer = new DNAAnalyzer(iQuantitySearch);
        idnaAnalyzerStats = new DNAAnalyzerStats(idnaData);
        bussiness = new DNAMagnetoBussiness(idnaData, idnaAnalyzer, idnaAnalyzerStats);
        /* End of Classes Construction */
    }
}
