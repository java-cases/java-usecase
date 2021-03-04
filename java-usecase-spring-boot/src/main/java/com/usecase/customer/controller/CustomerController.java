package com.usecase.customer.controller;

import com.usecase.annotation.RateLimit;
import com.usecase.customer.model.Customer;
import com.usecase.customer.service.CustomerService;
import com.usecase.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kenly
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/limit")
    @RateLimit(perSecond = 1.0, timeOut = 0)
    public String limit() {
        return "limited";
    }

    @GetMapping("/echo/{something}")
    public String echo(@PathVariable String something) {
        return something;
    }

    @GetMapping("/echo")
    public String echoParam(@RequestParam("something") String something) {
        return something;
    }

    @GetMapping("/default")
    public Customer defaultEmployee() {
        return service.getDefault();
    }

    @GetMapping("/dbsource")
    public Customer getDBSource() {
        return service.getDefault();
    }

    @GetMapping("/{id}")
    public Customer findByIdPathVariable(@PathVariable Long id) throws RestException {
        return service.find(id.intValue());
    }

    @GetMapping("/get")
    public Customer findByIdParam(@RequestParam("id") Long id) throws RestException {
        return service.find(id.intValue());
    }


}
