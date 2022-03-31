package com.hemit.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class Candidate extends PanacheMongoEntity {
    @NotEmpty
    public String firstName;
    @NotEmpty
    public String lastName;
    public String birthDate;
    @Email
    public String email;
    public String profilePictureURL;
    @NotEmpty
    public String description;
    @NotNull
    public Float minimumSalary;
    public List<String> offerIds;
    @NotEmpty
    public List<String> offerTypes;
    @NotNull
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
