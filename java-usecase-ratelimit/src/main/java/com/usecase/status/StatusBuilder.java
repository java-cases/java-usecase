package com.usecase.status;

public class StatusBuilder {
    private boolean success;
    private String message;
    private String statusCode;
    private Object data;

    public StatusBuilder success(boolean success) {
        this.success = success;
        return this;
    }

    public StatusBuilder message(String message) {
        this.message = message;
        return this;
    }

    public StatusBuilder statusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public StatusBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public ServiceStatus build() {
        return new ServiceStatus(success, message, statusCode, data);
    }
}