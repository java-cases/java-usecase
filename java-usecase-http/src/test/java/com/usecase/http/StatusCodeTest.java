package com.usecase.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusCodeTest {

    @Test
    void getCode() {
        assertEquals(200, StatusCode.OK.getCode());

        assertEquals(400, StatusCode.BAD_REQUEST.getCode());

        assertEquals(500, StatusCode.INTERNAL_SERVER_ERROR.getCode());
        assertEquals(501, StatusCode.NOT_IMPLEMENTED.getCode());
        assertEquals(502, StatusCode.BAD_GATEWAY.getCode());
        assertEquals(503, StatusCode.SERVICE_UNAVAILABLE.getCode());
        assertEquals(504, StatusCode.GATEWAY_TIMEOUT.getCode());
        assertEquals(505, StatusCode.VERSION_NOT_SUPPORTED.getCode());

        assertEquals(0, StatusCode.UNKNOWN_CODE.getCode());
    }

    @Test
    void from() {
        assertEquals(StatusCode.OK, StatusCode.from(200));

        assertEquals(StatusCode.BAD_REQUEST, StatusCode.from(400));

        assertEquals(StatusCode.INTERNAL_SERVER_ERROR, StatusCode.from(500));
        assertEquals(StatusCode.NOT_IMPLEMENTED, StatusCode.from(501));
        assertEquals(StatusCode.BAD_GATEWAY, StatusCode.from(502));
        assertEquals(StatusCode.SERVICE_UNAVAILABLE, StatusCode.from(503));
        assertEquals(StatusCode.GATEWAY_TIMEOUT, StatusCode.from(504));
        assertEquals(StatusCode.VERSION_NOT_SUPPORTED, StatusCode.from(505));

        assertEquals(StatusCode.UNKNOWN_CODE, StatusCode.from(0));
    }
}