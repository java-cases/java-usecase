package com.usecase.http.exceptions;

import com.usecase.http.StatusCode;

public class AuthenticationException extends ResponseException {

    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message, StatusCode status, Throwable cause) {
        super(message, status, cause);
    }

    public AuthenticationException(String message, StatusCode status) {
        super(message, status);
    }

    public AuthenticationException(String message, StatusCode status, String body) {
        super(message, status, body);
    }
}
