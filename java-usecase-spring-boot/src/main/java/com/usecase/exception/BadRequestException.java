package com.usecase.exception;

import com.usecase.status.RestStatus;
import org.springframework.http.HttpStatus;

public class BadRequestException extends RestException {

    public BadRequestException(RestStatus status) {
        super(status);
        status.setStatusCode(HttpStatus.BAD_REQUEST);
    }
}
