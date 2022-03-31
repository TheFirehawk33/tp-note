package com.hemit.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Offer extends PanacheMongoEntity {
    public String description;
    public List<String> keywords;
    public float salary;
    public String type;
    public String status;
    public Boolean openToRecruiters;
    public List<String> acceptedCandidateIds;
    public List<String> declinedCandidateIds;
    public String createdAt;
    public String SIREN;

    public Offer() {}

    public Offer(String description, List<String> keywords, float salary, String type, String status, Boolean openToRecruiters, List<String> acceptedCandidateIds, List<String> declinedCandidateIds, String createdAt, String SIREN) {
        this.description = description;
        this.keywords = keywords;
        this.salary = salary;
        this.type = type;
        this.status = status;
        this.openToRecruiters = openToRecruiters;
        this.acceptedCandidateIds = acceptedCandidateIds;
        this.declinedCandidateIds = declinedCandidateIds;
        this.createdAt = createdAt;
        this.SIREN = SIREN;
    }
}
