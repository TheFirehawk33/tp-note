package com.hemit.builder;

import com.hemit.models.Offer;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OfferBuilder {


    public static Offer buildGeneric() {
        Offer offer = new Offer("description", Arrays.asList("#manger", "#eul"), 12f,"CDI","Open",true, new ArrayList<>(),new ArrayList<>(),"1648813607","123456789");
        offer.id = new ObjectId();
        return offer;
    }


    public static Offer buildWithDescription(String description)
    {
        return buildGeneric()
                .setDescription(description);

    }
}
