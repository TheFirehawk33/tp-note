package com.hemit.utils;

import com.hemit.models.Company;
import io.restassured.response.ValidatableResponse;

import com.hemit.models.CreateResponse;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CompanyUtils {

    public static Company CompanyBuilder(String name) {
        return new Company(name, "983323000", "description", "logoURL.jpg", "1648732973", new ArrayList<Double>());
    }

    public static StatusAndContent<CreateResponse> createCompany(Company company) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(company)
                .when()
                .post("/companies")
                .then();

        int statusCode = response.extract().statusCode();
        CreateResponse content = new CreateResponse();
        if (statusCode == 201) {
            Company company1 = response.extract().as(Company.class);
            content.id = String.valueOf(company1.id);
        }

        return new StatusAndContent<>(statusCode, content);
    }

    public static StatusAndContent<CreateResponse> updateCompany(Company company, String id) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(company)
                .when()
                .put("/companies/"+id)
                .then();

        int statusCode = response.extract().statusCode();
        CreateResponse content = new CreateResponse();
        if (statusCode == 200) {
            Company company1 = response.extract().as(Company.class);
            content.id = String.valueOf(company1.id);
        }

        return new StatusAndContent<>(statusCode, content);
    }

    public static StatusAndContent<Company> getCompany(String id) {
        ValidatableResponse response = when().get("/companies/"+id).then();

        int statusCode = response.extract().statusCode();
        Company content = null;
        if (statusCode == 200) {
            content = response.extract().as(Company.class);
        }

        return new StatusAndContent<Company>(statusCode, content);
    }

    public static StatusAndContent<Company> getLastCompany() {
        ValidatableResponse response = when().get("/companies/last").then();

        int statusCode = response.extract().statusCode();
        Company content = null;
        if (statusCode == 200) {
            content = response.extract().as(Company.class);
        }

        return new StatusAndContent<Company>(statusCode, content);
    }

    public static StatusAndContent<CreateResponse> deleteCompany(String id) {
        ValidatableResponse response = when().delete("/companies/"+id).then();

        int statusCode = response.extract().statusCode();
        CreateResponse content = new CreateResponse();
        if (statusCode == 200) {
            Company company1 = response.extract().as(Company.class);
            content.id = String.valueOf(company1.id);
        }

        return new StatusAndContent(statusCode, content);
    }
}