package com.hemit.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDate;

public class Company extends PanacheMongoEntity {
    public String name;
    public String SIREN;
    public String description;
    public String logo;
    public String createdAt;

    public Company(){}

    public Company(String name, String SIREN, String description, String logo, String createdAt) {
        this.name = name;
        this.SIREN = SIREN;
        this.description = description;
        this.logo = logo;
        this.createdAt = createdAt;
    }
}
