package com.usecase.status;

public class ServiceStatus {

    private boolean success;
    private String message;
    private String statusCode;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public Object getData() {
        return data;
    }

    ServiceStatus(boolean success, String message, String statusCode, Object data) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static StatusBuilder builder() {
        return new StatusBuilder();
    }

    @Override
    public String toString() {
        return "ServiceStatus{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", data=" + data +
                '}';
    }
}
