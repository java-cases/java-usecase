package com.usecase.controller;

import com.usecase.annotation.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenly
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/limit")
    @RateLimit(perSecond = 1.0, timeOut = 0)
    public String limit() {
        return "limited";
    }

}
