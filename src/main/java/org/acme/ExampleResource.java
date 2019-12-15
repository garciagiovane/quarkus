package org.acme;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/welcome")
@Tag(name = "ExampleResource", description = "Expose some URI's to do operations")
public class ExampleResource {

    @Inject
    Service service;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(description = "Return Hello World message")
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
        return Car.saveCar(car);
    }

    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
        return Car.getAllCars();
    }

    @GET
    @Path("/cars/{carColor}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(description = "Return a cars list according to color passed", responseCode = "200", content = @Content(
                    schema = @Schema(implementation = Car[].class)
            ))
    })
    public List<Car> getCarsFiltered(@PathParam("carColor") String carColor) {
        return Car.getCarsFiltered(carColor);
    }
}