package org.acme.openapiswagger;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;
@OpenAPIDefinition(info = @Info(
        title = "Quarkus playground",
        description = "Exploring quarkus",
        version = "1.0.0",
        contact = @Contact(
                name = "Giovane de Garcia Pacheco",
                url = "github.com/garciagiovane",
                email = "giovane.garcia09@gmail.com"
        )
))
public class OpenApiSwaggerConfig extends Application {
}
