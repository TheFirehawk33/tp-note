package com.hemit.repositories;

import com.hemit.model.Candidate;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CandidateRepository implements PanacheMongoRepository<Candidate> {
}
