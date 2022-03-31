package java.com.hemit.controllers;

import com.hemit.models.Offer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.com.hemit.models.CreateResponse;
import java.com.hemit.utils.OfferUtils;
import java.com.hemit.utils.StatusAndContent;

import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OfferControllerTest {

    @Test
    public void create_should_return_status_202() {
        StatusAndContent<CreateResponse> response = OfferUtils.createOffer(OfferUtils.OfferBuilder("oui"));

        assertThat(response.statusCode, is(201));
    }

    @Test
    public void create_empty_should_return_status_400() {
        StatusAndContent<CreateResponse> reponse = OfferUtils.createOffer(new Offer());

    }
}
