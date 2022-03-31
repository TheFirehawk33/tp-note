package com.hemit.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Offer extends PanacheMongoEntity {
    @NotEmpty
    public String description;
    @NotNull
    public List<String> keywords;
    @NotNull
    public float salary;
    @NotEmpty
    public String type;
    @NotEmpty
    public String status;
    @NotNull
    public Boolean openToRecruiters;

    public List<String> acceptedCandidateIds;
    public List<String> declinedCandidateIds;
    @NotEmpty
    public String createdAt;
    @NotEmpty
    public String siren;

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
        this.siren = SIREN;
    }

}
