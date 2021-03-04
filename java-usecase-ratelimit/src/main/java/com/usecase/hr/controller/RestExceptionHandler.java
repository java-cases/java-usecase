package com.usecase.hr.controller;

import com.usecase.exception.BadRequestException;
import com.usecase.exception.RateLimitException;
import com.usecase.status.RestStatus;
import com.usecase.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestStatus handleException(BadRequestException e) {
        RestStatus status = e.getStatus();
        log.info("result:" + Serialization.toJson(status).orElse("error"));
        return status;
    }

    @ExceptionHandler({RateLimitException.class})
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ResponseBody
    public RestStatus handleException(RateLimitException e) {
        RestStatus status = e.getStatus();
        log.info("result:" + Serialization.toJson(status).orElse("error"));
        return status;
    }

}
