package org.acme;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/welcome")
@AllArgsConstructor
public class ExampleResource {

    private Service service;

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

    @POST
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car getCar(@Valid Car car) {
        car.persist();
        return car;
    }

    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
        return Car.listAll();
    }

    @GET
    @Path("/cars/{carColor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCarsFiltered(@PathParam("carColor") String carColor) {
        return Car.find("color like ?1", carColor).list();
    }
}