package com.hemit.builder;

import com.hemit.models.Company;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class CompanyBuilder {

    public static Company buildGeneric()
    {
        Company company =  new Company("name", "983323000", "description", "logoURL.jpg", "1648732973", new ArrayList<>());
        company.id = new ObjectId();
        return company;
    }

    public static Company buildWithName(String name) {
        return buildGeneric()
                .setName(name);
    }
}
