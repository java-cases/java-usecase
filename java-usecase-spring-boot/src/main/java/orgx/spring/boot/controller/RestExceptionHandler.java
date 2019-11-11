package orgx.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import orgx.spring.boot.exception.RestException;
import orgx.spring.boot.status.ErrorResult;
import orgx.spring.boot.util.Serialization;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({RestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handleException(RestException e){

        ErrorResult error =new ErrorResult("failed",
                "PM-1-501",e.getLocalizedMessage());

        log.info("result:" + Serialization.toJson(error).orElse("error"));
        return error;

    }

}
