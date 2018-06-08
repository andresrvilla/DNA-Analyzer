package com.dna_analyzer.api.controllers;

import com.dna_analyzer.api.request.MutantRequest;
import com.dna_analyzer.api.response.ErrorResponse;
import com.dna_analyzer.models.DNA;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/mutant")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DnaMutantController extends BaseController {
    public DnaMutantController() throws SQLException, ClassNotFoundException, IOException {
        readConfig();
        InitializeDependencies();
    }

    @POST
    public Response IsMutant(MutantRequest request) {
        try {
            if (bussiness.isMutant(new DNA(request.getDna()))) {
                return Response.status(200).build();
            } else {
                return Response.status(403).build();
            }
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage());
            return Response.status(500).entity(response).build();
        }
    }
}
