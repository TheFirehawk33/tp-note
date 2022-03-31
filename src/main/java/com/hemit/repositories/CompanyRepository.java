package com.hemit.repositories;

import com.hemit.models.Company;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements PanacheMongoRepository<Company> {

}
