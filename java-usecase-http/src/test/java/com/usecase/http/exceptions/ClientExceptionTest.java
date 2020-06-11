package com.usecase.http.exceptions;

import com.usecase.http.StatusCode;
import org.junit.jupiter.api.Test;

class ClientExceptionTest {

    @Test
    void testToString() {
        System.out.println(getException());
    }

    private ClientException getException() {
        return new ClientException("ClientException", StatusCode.BAD_REQUEST);
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