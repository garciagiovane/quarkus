package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    private Service service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return service.hello();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return service.hello();
    }
}