package com.hemit.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Company extends PanacheMongoEntity {
    public String name;
    public String SIREN;
    public String description;
    public String logoURL;
    public String createdAt;
    public List<Double> location;

    public Company(){}

    public Company(String name, String SIREN, String description, String logoURL, String createdAt, List<Double> location) {
        this.name = name;
        this.SIREN = SIREN;
        this.description = description;
        this.logoURL = logoURL;
        this.createdAt = createdAt;
        this.location = location;
    }
}
