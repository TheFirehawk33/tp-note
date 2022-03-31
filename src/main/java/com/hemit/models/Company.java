package com.hemit.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Company extends PanacheMongoEntity {
    @NotEmpty
    public String name;

    @NotEmpty
    public String siren;

    @NotEmpty
    public String description;

    @NotEmpty
    public String logoURL;

    @NotEmpty
    public String createdAt;

    public List<Double> location;

    public Company(){}

    public Company(String name, String siren, String description, String logoURL, String createdAt, List<Double> location) {
        this.name = name;
        this.siren = siren;
        this.description = description;
        this.logoURL = logoURL;
        this.createdAt = createdAt;
        this.location = location;
    }
}
