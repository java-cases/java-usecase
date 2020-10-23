package com.usecase.exception;

import com.usecase.status.ServiceStatus;

public class HRServieException extends RestException {

    public HRServieException(ServiceStatus status) {
        super(status);
    }
}
