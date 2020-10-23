package com.usecase.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString()
public class ServiceStatus {
    private String message;
    private String errorCode;
    private int statusCode;
    private Object data;

    public static StatusBuilder builder() {
        return new StatusBuilder();
    }
}
