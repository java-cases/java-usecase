package com.usecase.exception;

import com.usecase.status.ServiceStatus;

public class RestException extends Exception {

    private ServiceStatus status;

    public RestException(final ServiceStatus status) {
        super(status.getMessage());
        this.setStatus(status);
    }

    public RestException(final ServiceStatus status, final Throwable cause) {
        super(cause);
        this.setStatus(status);
    }

    public RestException(final String message) {
        super(message);
    }

    public RestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RestException(final Throwable cause) {
        super(cause);
    }

    public RestException(final String message, final ServiceStatus status) {
        super(message);
        this.setStatus(status);
    }

    public ServiceStatus getStatus() {
        return this.status;
    }

    private void setStatus(final ServiceStatus status) {
        this.status = status;
    }
}
