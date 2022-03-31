package com.hemit.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Candidate extends PanacheMongoEntity {
    public String firstName;
    public String lastName;
    public String birthDate;
    public String email;
    public String profilePictureURL;
    public String description;
    public float minimumSalary;
    public List<String> offerIds;
    public List<String> offerTypes;
    public List<String> keywords;
    public String lastLoggedIn;

    public Candidate() {}

    public Candidate(String firstName, String lastName, String birthDate, String email, String profilePictureURL, String description, float minimumSalary, List<String> offerIds, List<String> offerTypes, List<String> keywords, String lastLoggedIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.profilePictureURL = profilePictureURL;
        this.description = description;
        this.minimumSalary = minimumSalary;
        this.offerIds = offerIds;
        this.offerTypes = offerTypes;
        this.keywords = keywords;
        this.lastLoggedIn = lastLoggedIn;
    }
}
