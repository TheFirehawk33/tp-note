package com.hemit.controllers;

import com.hemit.model.Company;
import com.hemit.repositories.CompanyRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Inject
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @POST
    public Response create(Company company) {
        companyRepository.persist(company);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Company company) {
        company.id = new ObjectId(id);
        companyRepository.update(company);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        Company company = companyRepository.findById(new ObjectId(id));
        companyRepository.delete(company);
    }

    @GET
    @Path("/{id}")
    public Company get(@PathParam("id") String id) {
        return companyRepository.findById(new ObjectId(id));
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