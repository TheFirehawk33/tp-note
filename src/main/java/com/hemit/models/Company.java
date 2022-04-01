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

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Company setSiren(String siren) {
        this.siren = siren;
        return this;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public Company setLogoURL(String logoURL) {
        this.logoURL = logoURL;
        return this;
    }

    public Company setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Company setLocation(List<Double> location) {
        this.location = location;
        return this;
    }
}
