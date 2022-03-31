package com.hemit.controllers;

import com.hemit.models.Company;
import com.hemit.models.CreateResponse;
import com.hemit.utils.CompanyUtils;
import com.hemit.utils.StatusAndContent;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CompanyControllerTest {

    @Test
    public void create_shouldReturn_201_when_goodRequest() {
        StatusAndContent<CreateResponse> response = CompanyUtils.createCompany(CompanyUtils.CompanyBuilder());

        assertThat(response.statusCode, is(201));
    }

    @Test
    public void create_empty_shouldReturn_400_when_badRequest() {
        StatusAndContent<CreateResponse> response = CompanyUtils.createCompany(new Company());

        assertThat(response.statusCode, is(400));
    }

    @Test
    public void getById_shouldReturn_200andContent() {
        StatusAndContent<Company> response = CompanyUtils.getCompany("624570121dce5a09fd16c0e6");

        assertThat(response.statusCode, is(200));
    }
}
