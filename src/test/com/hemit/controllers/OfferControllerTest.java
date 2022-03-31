package com.hemit.controllers;

import com.hemit.models.Offer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import com.hemit.models.CreateResponse;
import com.hemit.utils.OfferUtils;
import com.hemit.utils.StatusAndContent;

import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OfferControllerTest {

    @Test
    public void create_should_return_status_201() {
        StatusAndContent<CreateResponse> response = OfferUtils.createOffer(OfferUtils.OfferBuilder("oui"));

        assertThat(response.statusCode, is(201));
    }

    @Test
    public void create_empty_should_return_status_404() {
        StatusAndContent<CreateResponse> response = OfferUtils.createOffer(new Offer());

        assertThat(response.statusCode, is(404));
    }

    @Test
    public void create_wrong_should_return_status_400() {
        StatusAndContent<CreateResponse> response = OfferUtils.createOffer(OfferUtils.OfferBuilder("sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac"));

        assertThat(response.statusCode,is(400));
    }

    @Test
    public void update_should_return_status_200() {
        StatusAndContent<CreateResponse> response = OfferUtils.createOffer(OfferUtils.OfferBuilder("oui"));


    }
}
