package com.usecase.status;

public class StatusBuilder {
    private String message;
    private String errorCode;
    private int statusCode;
    private Object data;

    public StatusBuilder message(String message) {
        this.message = message;
        return this;
    }

    public StatusBuilder errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public StatusBuilder statusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public StatusBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public ServiceStatus build() {
        return new ServiceStatus(message, errorCode, statusCode, data);
    }
}