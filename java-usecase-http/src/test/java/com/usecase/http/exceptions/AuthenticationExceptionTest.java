package com.usecase.http.exceptions;

import com.usecase.http.StatusCode;
import org.junit.jupiter.api.Test;

class AuthenticationExceptionTest {

    @Test
    void testToString() {
        System.out.println(getException());
    }

    private AuthenticationException getException() {
        return new AuthenticationException("AuthenticationException", StatusCode.UNAUTHORIZED);
    }

    @Test
    void getBody() {
        System.out.println(getException().getBody());
    }

    @Test
    void getStatus() {
        System.out.println(getException().getStatus());
    }
}