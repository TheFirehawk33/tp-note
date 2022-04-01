package com.hemit.services;

import com.hemit.builder.CandidateBuilder;
import com.hemit.builder.CompanyBuilder;
import com.hemit.builder.OfferBuilder;
import com.hemit.models.Candidate;
import com.hemit.models.Company;
import com.hemit.models.Offer;
import com.hemit.repositories.CandidateRepository;
import com.hemit.repositories.CompanyRepository;
import com.hemit.repositories.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;


public class MatchServicesTest {

    @Mock
    OfferRepository offerRepository;
    @Mock
    CompanyRepository companyRepository;
    @Mock
    CandidateRepository candidateRepository;

    MatchService matchService;
    @BeforeEach
    void setup()
    {
        offerRepository = Mockito.mock(OfferRepository.class);
        companyRepository = Mockito.mock(CompanyRepository.class);
        candidateRepository = Mockito.mock(CandidateRepository.class);
        matchService = new MatchService(offerRepository,companyRepository,candidateRepository);
    }

    @Test
    public void updated_match_should_return_true() {
        //Prepare
        Offer offer = OfferBuilder.buildWithDescription("test");
        Candidate candidate = CandidateBuilder.buildGeneric();
        Company company = CompanyBuilder.buildWithName("Légale");

        Mockito.when(offerRepository.findById(offer.id)).thenReturn(offer);
        Mockito.when(candidateRepository.findById(candidate.id)).thenReturn(candidate);
        Mockito.when(companyRepository.findById(company.id)).thenReturn(company);

        //Then
        boolean isMatch = matchService.isMatchableAndUpdate(candidate.id.toString(),company.id.toString(),offer.id.toString(),true);
        System.out.printf(String.valueOf(isMatch));

        //Assert
        Assertions.assertTrue(isMatch);

    }
}
