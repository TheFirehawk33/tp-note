package com.hemit.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.Date;

public class Candidate extends PanacheMongoEntity {
    public String firstName;
    public String lastName;
    public Date birthDate;
    public String email;
    public String profilePictureURL;
    public String description;
    public int minimumWage;
    public String[] offerTypes;
    public String[] keywords;
    public Date lastLoggedIn;

    public Candidate() {}

    public Candidate(String firstName, String lastName, Date birthDate, String email, String profilePictureURL, String description, int minimumWage, String[] offerTypes, String[] keywords, Date lastLoggedIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.profilePictureURL = profilePictureURL;
        this.description = description;
        this.minimumWage = minimumWage;
        this.offerTypes = offerTypes;
        this.keywords = keywords;
        this.lastLoggedIn = lastLoggedIn;
    }
}
