package com.dna_analyzer.api.controllers;

import com.dna_analyzer.data.exceptions.DNADataException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DNAStatsControllerForTestTest {
    @Test
    void statsShouldReturnPreconfiguredStats() throws SQLException, ClassNotFoundException, DNADataException, JSONException, IOException {
        DNAStatsControllerForTest contoller = new DNAStatsControllerForTest();
        Response response = contoller.Stats();
        assertEquals(response.getStatus(), 200);
        JSONObject resultobject = (JSONObject) response.getEntity();
        assertEquals(resultobject.get("Stats1"), (long) 1);
        assertEquals(resultobject.get("Stats2"), (long) 2);
        assertEquals(resultobject.get("Stats3"), (long) 3);
        assertEquals(resultobject.get("ratio"), "1.0:2.0:3.0");
    }
}