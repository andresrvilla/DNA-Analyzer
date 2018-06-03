package com.dna_analyzer.api;

import com.dna_analyzer.api.request.MutantRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stats")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DnaStatsController {
    @GET
    public Response Stats() {
        MutantRequest response = new MutantRequest();
        response.setDna(new String[]{"AA", "BB"});
        return Response.status(200).entity(response).build();
    }
}
