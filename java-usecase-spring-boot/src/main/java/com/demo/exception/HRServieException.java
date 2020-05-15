package com.demo.exception;

import com.demo.status.ServiceStatus;

public class HRServieException extends RestException {

    public HRServieException(ServiceStatus status) {
        super(status);
    }
}
