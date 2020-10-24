package com.usecase.exception;

import com.usecase.status.RestStatus;

public class RateLimitException extends RestException {

    public RateLimitException(RestStatus status) {
        super(status);
    }
}
