
package com.usecase.http.exceptions;

public class ApiNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ApiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiNotFoundException(String message) {
        super(message);
    }

    public ApiNotFoundException(Throwable cause) {
        super(cause);
    }
}
