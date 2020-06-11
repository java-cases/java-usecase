package com.usecase.http.exceptions;

import com.usecase.http.StatusCode;
import org.junit.jupiter.api.Test;

class ServerExceptionTest {

    @Test
    void testToString() {
        System.out.println(getException());
    }

    private ServerException getException() {
        return new ServerException("ServerException", StatusCode.INTERNAL_SERVER_ERROR);
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