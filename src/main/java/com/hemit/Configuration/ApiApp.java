package com.hemit.Configuration;


import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;


@OpenAPIDefinition(

        info = @Info(
                title="TP API",
                version = "1.0.1",
                contact = @Contact(
                        name = "tp team",
                        url = "http://tp.com/contact",
                        email = "techsupport@example.com"))

)
public class ApiApp extends Application {
}
