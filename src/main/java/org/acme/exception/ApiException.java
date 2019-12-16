package org.acme.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiException extends RuntimeException {

    private final Integer statusCode;
    private final String message;

    public ApiException(String message, Integer statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    public ExceptionModel getExceptionModel() {
        return ExceptionModel.builder()
                .message(this.message)
                .statusCode(this.statusCode)
                .build();
    }

}
