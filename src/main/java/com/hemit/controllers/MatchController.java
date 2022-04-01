package com.hemit.controllers;

import com.hemit.repositories.CandidateRepository;
import com.hemit.repositories.CompanyRepository;
import com.hemit.repositories.OfferRepository;
import com.hemit.services.MatchService;
import io.netty.handler.codec.http.HttpResponseStatus;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/matchs")
@Consumes("application/json")
@Produces("application/json")
public class MatchController {

    private final MatchService matchService;

    @Inject
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Path("/companies/profiles")
    public Response getProfile(String idCompany, String idCandidate, String idOffer, Boolean isAccepted) {
        boolean isMatched = matchService.isMatchableAndUpdate(idCandidate, idCompany, idOffer,isAccepted);

        if(isMatched)
            return Response.status(HttpResponseStatus.OK.code()).build();

        return Response.status(HttpResponseStatus.EXPECTATION_FAILED.code()).build();
    }

}
