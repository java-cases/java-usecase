package com.usecase.controller;

import com.usecase.exception.RestException;
import com.usecase.status.ServiceStatus;
import com.usecase.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({RestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceStatus handleException(RestException e) {
        ServiceStatus status =e.getStatus();
        log.info("result:" + Serialization.toJson(status).orElse("error"));
        return status;
    }

}
