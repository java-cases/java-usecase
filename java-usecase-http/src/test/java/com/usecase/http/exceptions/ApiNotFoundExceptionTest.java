package com.usecase.http.exceptions;

import org.junit.jupiter.api.Test;

class ApiNotFoundExceptionTest {

    @Test
    void testToString() {
        System.out.println(getException());
    }

    private ApiNotFoundException getException() {
        return new ApiNotFoundException("ApiNotFoundException");
    }
}