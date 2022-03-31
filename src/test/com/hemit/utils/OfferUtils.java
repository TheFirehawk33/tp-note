package com.hemit.utils;

import com.hemit.models.Offer;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import com.hemit.models.CreateResponse;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OfferUtils {

    public static Offer OfferBuilder(String description) {
        List<String> list = Arrays.asList("oui", "non");
        return new Offer(description, list, 12f,"feu","paralisé",true,list,list,"aujourd'hui","ariel");
    }

    public static StatusAndContent<CreateResponse> createOffer(Offer offer) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(offer)
                .when()
                .post("/offers")
                .then();

        int statusCode = response.extract().statusCode();
        CreateResponse content = new CreateResponse();
        if (statusCode == 201) {
            Offer responsedata1 = response.extract().as(Offer.class);

            content.id= String.valueOf(responsedata1.id);
        }

        return new StatusAndContent<>(statusCode, content);
    }

}
