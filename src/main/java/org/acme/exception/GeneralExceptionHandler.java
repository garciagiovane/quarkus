package org.acme.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ExceptionModel.builder()
                        .message(e.getMessage())
                        .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
