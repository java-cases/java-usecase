package com.usecase.exception;

import com.usecase.status.RestStatus;

public class HRServieException extends RestException {

    public HRServieException(RestStatus status) {
        super(status);
    }
}
