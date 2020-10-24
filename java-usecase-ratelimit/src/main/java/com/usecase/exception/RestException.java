package com.usecase.exception;

import com.usecase.status.RestStatus;

public class RestException extends Exception {

    private RestStatus status;

    public RestException(final String message) {
        super(message);
    }

    public RestException(final RestStatus status) {
        super(status.getMessage());
        this.setStatus(status);
    }

    public RestException(final RestStatus status, final Throwable cause) {
        super(status.getMessage(), cause);
        this.setStatus(status);
    }

    public RestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RestException(final Throwable cause) {
        super(cause);
    }

    public RestStatus getStatus() {
        return this.status;
    }

    private void setStatus(final RestStatus status) {
        this.status = status;
    }
}
