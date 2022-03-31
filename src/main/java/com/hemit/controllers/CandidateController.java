package com.hemit.controllers;

import com.hemit.models.Candidate;
import com.hemit.repositories.CandidateRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;

    @Inject
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @POST
    public Response create(Candidate candidate) {
        candidateRepository.persist(candidate);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Candidate candidate) {
        candidate.id = new ObjectId(id);
        candidateRepository.update(candidate);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        Candidate candidate = candidateRepository.findById(new ObjectId(id));
        candidateRepository.delete(candidate);
    }

    @GET
    @Path("/{id}")
    public Candidate get(@PathParam("id") String id) {
        return candidateRepository.findById(new ObjectId(id));
    }

    @GET
    public List<Candidate> list() {
        return candidateRepository.listAll();
    }

    @GET
    @Path("/count")
    public Long count() {
        return candidateRepository.count();
    }

}
