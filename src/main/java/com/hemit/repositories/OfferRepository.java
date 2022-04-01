package com.hemit.repositories;

import com.hemit.models.Offer;
import com.hemit.utils.OfferStatusEnum;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OfferRepository implements PanacheMongoRepository<Offer> {

    public List<Offer> listOffers(int limit) {
        return find("status", OfferStatusEnum.Open).range(0, limit).list();
    }
}
