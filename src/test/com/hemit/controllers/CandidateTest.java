package com.hemit.controllers;

import com.hemit.models.Candidate;
import com.hemit.repositories.CandidateRepository;
import com.hemit.utils.OfferTypeEnum;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class CandidateTest {


    @Inject
    CandidateRepository repository;
    CandidateController controller;

    @BeforeEach
    void setup()
    {
        controller = new CandidateController(repository);
    }

    public static Stream<Arguments> creationTestParameter()
    {
        return Stream.of(
                Arguments.of(
                        "Nominal case",
                        HttpResponseStatus.CREATED.code(),
                        "firstName",
                        "lastName",
                        "21/11/71",
                        "email@ok.com",
                        "http://aled.com/img.jpg",
                        "description",
                        10.2f,
                        List.of("offerId1"),
                        List.of(OfferTypeEnum.CDD,OfferTypeEnum.CDI),
                        List.of("#java")
                ),
                Arguments.of(
                        "Without optional case",
                        HttpResponseStatus.CREATED.code(),
                        "firstName",
                        "lastName",
                        null,
                        "email@ok.com",
                        null,
                        "description",
                        10.2f,
                        null,
                        List.of(OfferTypeEnum.CDD,OfferTypeEnum.CDI),
                        List.of("#java")
                ),
                Arguments.of(
                        "Without require cases",
                        HttpResponseStatus.BAD_REQUEST.code(),
                        "",
                        "lastName",
                        null,
                        null,
                        null,
                        "description",
                        0f,
                        null,
                        List.of(OfferTypeEnum.CDD,OfferTypeEnum.CDI),
                        List.of("#java")
                )
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("creationTestParameter")
    void creationTest(String nameTest, int expectedCode, String firstName, String lastName,
                      String birth, String email, String profilePictureUrl, String description,
                      Float minimumSalary, List<String> offerIds, List<OfferTypeEnum> offerTypes, List<String> keywords)
    {
        //Given
        Candidate candidate = new Candidate(firstName,lastName,birth,email,profilePictureUrl,description,minimumSalary,offerIds, offerTypes,keywords,null);

        //Then
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(candidate)
                .when()
                .post("/candidates")
                .then();

        int statusCode = response.extract().statusCode();

        //Assert
        assertEquals(expectedCode,statusCode);
    }
}
