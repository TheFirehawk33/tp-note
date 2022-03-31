package com.hemit.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Offer extends PanacheMongoEntity {
    public String description;
    public String[] keywords;
    public int salary;
    public String type;
    public String status;
    public Boolean openToRecruiters;

    public Offer() {}

    public Offer(String description, String[] keywords, int salary, String type, String status, Boolean openToRecruiters) {
        this.description = description;
        this.keywords = keywords;
        this.salary = salary;
        this.type = type;
        this.status = status;
        this.openToRecruiters = openToRecruiters;
    }
}
