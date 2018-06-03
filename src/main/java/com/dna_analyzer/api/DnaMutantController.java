package com.dna_analyzer.api;

import com.dna_analyzer.api.request.MutantRequest;
import com.dna_analyzer.api.response.ErrorResponse;
import com.dna_analyzer.bussiness.DNAAnalyzer;
import com.dna_analyzer.exceptions.InvalidDNASizeException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mutant")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DnaMutantController {
    @POST
    public Response IsMutant(MutantRequest request) {
        try {
            if (DNAAnalyzer.isMutant(request.getDna())) {
                return Response.status(200).build();
            } else {
                return Response.status(403).build();
            }
        } catch (InvalidDNASizeException e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage());
            return Response.status(500).entity(response).build();
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage());
            return Response.status(500).entity(response).build();
        }
    }
}
