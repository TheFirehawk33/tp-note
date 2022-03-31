package com.hemit.repositories;

import com.hemit.model.Offer;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OfferRepository implements PanacheMongoRepository<Offer> {
}
