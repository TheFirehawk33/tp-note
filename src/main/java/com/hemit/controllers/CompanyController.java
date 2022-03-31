package com.hemit.controllers;

import com.hemit.models.Company;
import com.hemit.repositories.CompanyRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/companies")
@Consumes("application/json")
@Produces("application/json")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Inject
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @POST
    public Response create(@Valid Company company) {
        companyRepository.persist(company);
        return Response.ok(company).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, @Valid Company company) {
        company.id = new ObjectId(id);
        companyRepository.update(company);
        return Response.ok(company).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        Company company = companyRepository.findById(new ObjectId(id));
        companyRepository.delete(company);
        return Response.ok(company).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Company get(@PathParam("id") String id) {
        return companyRepository.findById(new ObjectId(id));
    }

    @GET
    @Path("/last")
    public Company getLast() {
        return companyRepository.findAll().firstResult();
    }

    @GET
    public List<Company> list() {
        return companyRepository.listAll();
    }

    @GET
    @Path("/count")
    public Long count() {
        return companyRepository.count();
    }

}