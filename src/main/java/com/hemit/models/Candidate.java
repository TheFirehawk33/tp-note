package com.hemit.models;

import com.hemit.utils.OfferTypeEnum;
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
    public List<OfferTypeEnum> offerTypes;
    @NotNull
    public List<String> keywords;
    public String lastLoggedIn;

    public Candidate() {}

    public Candidate(String firstName, String lastName, String birthDate, String email, String profilePictureURL, String description, float minimumSalary, List<String> offerIds, List<OfferTypeEnum> offerTypes, List<String> keywords, String lastLoggedIn) {
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

    public Candidate setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Candidate setLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public Candidate setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;

    }

    public Candidate setEmail(String email) {
        this.email = email;
        return this;

    }

    public Candidate setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
        return this;

    }

    public Candidate setDescription(String description) {
        this.description = description;
        return this;

    }

    public Candidate setMinimumSalary(Float minimumSalary) {
        this.minimumSalary = minimumSalary;
        return this;

    }

    public Candidate setOfferIds(List<String> offerIds) {
        this.offerIds = offerIds;
        return this;

    }

    public Candidate setOfferTypes(List<OfferTypeEnum> offerTypes) {
        this.offerTypes = offerTypes;
        return this;

    }

    public Candidate setKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;

    }

    public Candidate setLastLoggedIn(String lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
        return this;

    }
}
