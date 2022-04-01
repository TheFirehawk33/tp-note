package com.hemit.builder;

import com.hemit.models.Candidate;
import com.hemit.utils.OfferTypeEnum;
import org.bson.types.ObjectId;

import java.util.Collections;
import java.util.List;

public class CandidateBuilder {

    public static Candidate buildEmpty()
    {
        return new Candidate();
    }

    public static Candidate buildGeneric()
    {
        return buildEmpty()
                .setBirthDate("12/12/12")
                .setDescription("description")
                .setEmail("mail@ok.com")
                .setFirstName("firstName")
                .setLastName("lastName")
                .setKeywords(List.of("#java"))
                .setMinimumSalary(15f)
                .setLastLoggedIn("1111")
                .setOfferIds(Collections.emptyList())
                .setOfferTypes(List .of(OfferTypeEnum.CDD))
                .setProfilePictureURL("url.pp/img.jpg");
    }

    public static ObjectId buildGeneric(ObjectId id){
        return buildGeneric()
                .id = id;
    }
}
