package com.hemit.controllers;

import com.hemit.builder.CompanyBuilder;
import com.hemit.models.Company;
import com.hemit.models.CreateResponse;
import com.hemit.utils.CompanyUtils;
import com.hemit.utils.StatusAndContent;
import io.quarkus.test.junit.QuarkusTest;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CompanyControllerTest {

    @Test
    public void create_shouldReturn_201_when_goodRequest() {
        StatusAndContent<CreateResponse> response = CompanyUtils.createCompany(CompanyBuilder.buildWithName("name2"));

        assertThat(response.statusCode, is(201));
    }

    @Test
    public void create_empty_shouldReturn_400_when_badRequest() {
        StatusAndContent<CreateResponse> response = CompanyUtils.createCompany(new Company());

        assertThat(response.statusCode, is(400));
    }

    @Test
    public void getById_shouldReturn_200() {
        StatusAndContent<Company> response = CompanyUtils.getCompany(String.valueOf(CompanyUtils.getLastCompany().content.id));

        assertThat(response.statusCode, is(200));
    }

    @Test
    public void getById_shouldReturn_204_when_unknownId() {
        StatusAndContent<Company> response = CompanyUtils.getCompany(String.valueOf(new ObjectId()));

        assertThat(response.statusCode, is(204));
    }

    @Test
    public void delete_shouldReturn_200() {
        StatusAndContent<CreateResponse> response = CompanyUtils.deleteCompany(String.valueOf(CompanyUtils.getLastCompany().content.id));

        assertThat(response.statusCode, is(200));
    }

    @Test
    public void delete_shouldReturn_400_when_unknownId() {
        StatusAndContent<CreateResponse> response = CompanyUtils.deleteCompany(String.valueOf(new ObjectId()));

        assertThat(response.statusCode, is(400));
    }

    @Test
    public void update_shouldReturn_200() {
        StatusAndContent<CreateResponse> response = CompanyUtils.updateCompany(CompanyBuilder.buildWithName("name2"), String.valueOf(CompanyUtils.getLastCompany().content.id));

        assertThat(response.statusCode, is(200));
    }

    @Test
    public void update_shouldReturn_400_when_unknownId() {
        StatusAndContent<CreateResponse> response = CompanyUtils.updateCompany(CompanyBuilder.buildWithName("name2"), String.valueOf(new ObjectId()));

        assertThat(response.statusCode, is(400));
    }
}
