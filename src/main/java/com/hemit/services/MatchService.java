package com.hemit.services;

import com.hemit.models.Candidate;
import com.hemit.models.Company;
import com.hemit.models.Offer;
import com.hemit.repositories.CandidateRepository;
import com.hemit.repositories.CompanyRepository;
import com.hemit.repositories.OfferRepository;
import org.bson.types.ObjectId;

public class MatchService {


    private final OfferRepository offerRepository;
    private final CompanyRepository companyRepository;
    private final CandidateRepository candidateRepository;

    public MatchService(OfferRepository offerRepository, CompanyRepository companyRepository, CandidateRepository candidateRepositoryRepository) {
        this.offerRepository = offerRepository;
        this.companyRepository = companyRepository;
        this.candidateRepository = candidateRepositoryRepository;
    }

    public boolean isMatchableAndUpdate(String idCandidate, String idCompany, String idOffer, Boolean isAccepted) {
        Offer offer = offerRepository.findById(new ObjectId(idOffer));
        Candidate candidate = candidateRepository.findById(new ObjectId(idCandidate));
        Company company = companyRepository.findById(new ObjectId(idCompany));

        if(company.siren.equals(offer.siren) && offer.status.equals("Open") && offer.acceptedCandidateIds.contains(candidate.id.toString()) || isAccepted) {
            offer.acceptedCandidateIds.add(String.valueOf(candidate.id));
            offerRepository.update(offer);
            return true;
        }
        return false;
    }
}
