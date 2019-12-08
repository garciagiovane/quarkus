package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/welcome")
public class ExampleResource {

    private Service service;

    public ExampleResource(Service service) {
        this.service = service;
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return service.hello();
    }

    @GET
    @Path("/properties")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> returnValueFromApplicationProperties() {
        return service.getListFromProperties();
    }

    @GET
    @Path("/properties-unnamed")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer returnValueFromApplicationPropertiesUnnamed() {
        return service.getFromPropertyUnnamed();
    }

    @GET
    @Path("/string")
    @Produces(MediaType.TEXT_PLAIN)
    public String getString() {
        return service.getString();
    }
}