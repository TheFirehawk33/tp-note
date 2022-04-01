package com.hemit.models;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@Produces("application/json")
@Consumes("application/json")
public class CreateResponse {
    public String id;

    public CreateResponse() {
    }

    public CreateResponse(String id) {
        this.id = id;
    }

}
