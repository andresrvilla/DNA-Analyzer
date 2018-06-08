package com.dna_analyzer.api.controllers;

import com.dna_analyzer.data.exceptions.DNADataException;
import org.codehaus.jettison.json.JSONException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/stats")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DnaStatsController extends BaseController {
    public DnaStatsController() throws SQLException, ClassNotFoundException, IOException {
        readConfig();
        InitializeDependencies();
    }

    @GET
    public Response Stats() throws ClassNotFoundException, DNADataException, JSONException {
        return Response.status(200).entity(bussiness.stats()).build();
    }
}
