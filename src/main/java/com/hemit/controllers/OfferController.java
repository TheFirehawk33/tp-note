package com.hemit.controllers;

import com.hemit.models.Offer;
import com.hemit.repositories.OfferRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
@Path("/offers")
public class OfferController {

    private final OfferRepository offerRepository;

    @Inject
    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @POST
    public Response create(@Valid Offer offer) {
        offerRepository.persist(offer);
        return Response.ok(offer).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id,@Valid Offer offer) {
        offer.id = new ObjectId(id);
        offerRepository.update(offer);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        Offer offer = offerRepository.findById(new ObjectId(id));
        offerRepository.delete(offer);
    }

    @GET
    @Path("/{id}")
    public Offer get(@PathParam("id") String id) {
        return offerRepository.findById(new ObjectId(id));
    }

    @GET
    public List<Offer> list() {
        return offerRepository.listAll();
    }

    @GET
    @Path("/count")
    public Long count() {
        return offerRepository.count();
    }

}
