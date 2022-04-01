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

    public static StatusAndContent<CreateResponse> createOffer(Offer offer) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(offer)
                .when()
                .post("/offers")
                .then();

        int statusCode = response.extract().statusCode();
        String data = response.toString();
        CreateResponse content = new CreateResponse();
        if (statusCode == 201) {
            Offer responsedata1 = response.extract().as(Offer.class);

            content.id= String.valueOf(responsedata1.id);
        }


        return new StatusAndContent<>(statusCode, content);
    }

    public static StatusAndContent<CreateResponse> updateOffer(String id,Offer offer) {
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

    public static StatusAndContent<CreateResponse> DeleteOffer(String id) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .when()
                .delete("/offers/"+id)
                .then();
        int statusCode = response.extract().statusCode();
        CreateResponse content = new CreateResponse();

        return new StatusAndContent<>(statusCode, content);
    }

    public static StatusAndContent<CreateResponse> GetOffer(String id) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .when()
                .get("/offers/"+id)
                .then();
        int statusCode = response.extract().statusCode();
        CreateResponse content = new CreateResponse();

        if (statusCode == 200) {
            Offer responsedata1 = response.extract().as(Offer.class);
            content.id= String.valueOf(responsedata1.id);
        }
        return new StatusAndContent<>(statusCode, content);
    }

}
