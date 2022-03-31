package com.hemit.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Offer extends PanacheMongoEntity {
    public String description;
    public List<String> keywords;
    public int salary;
    public String type;
    public String status;
    public Boolean openToRecruiters;
    public List<String> declinedCandidates;
    public String createdAt;
    public String SIREN;

    public Offer() {}

    public Offer(String description, List<String> keywords, int salary, String type, String status, Boolean openToRecruiters, List<String> declinedCandidates, String createdAt, String SIREN) {
        this.description = description;
        this.keywords = keywords;
        this.salary = salary;
        this.type = type;
        this.status = status;
        this.openToRecruiters = openToRecruiters;
        this.declinedCandidates = declinedCandidates;
        this.createdAt = createdAt;
        this.SIREN = SIREN;
    }
}
