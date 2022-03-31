package java.com.hemit.utils;

import com.hemit.models.Offer;
import io.restassured.response.ValidatableResponse;

import java.com.hemit.models.CreateResponse;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OfferUtils {

    public static StatusAndContent<CreateResponse> createOffer(String description) {
        List<String> list = Arrays.asList("oui", "non");
        Offer offer = new Offer(description, list, 12f,"feu","paralisé",true,list,list,"aujourd'hui","ariel");
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(offer)
                .when()
                .post("/tournaments")
                .then();

        int statusCode = response.extract().statusCode();
        CreateResponse content = null;
        if (statusCode == 201) {
            content = response.extract().as(CreateResponse.class);
        }

        return new StatusAndContent<>(statusCode, content);
    }

}
