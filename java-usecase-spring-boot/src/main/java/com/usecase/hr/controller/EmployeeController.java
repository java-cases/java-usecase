package com.usecase.hr.controller;

import com.usecase.annotation.RateLimit;
import com.usecase.exception.RestException;
import com.usecase.hr.model.Employee;
import com.usecase.hr.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kenly
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private HRService hrService;

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
    public Employee defaultEmployee() {
        return hrService.getDefault();
    }

    @GetMapping("/dbsource")
    public Employee getDBSource() {
        return hrService.getDefault();
    }

    @GetMapping("/{id}")
    public Employee findByIdPathVariable(@PathVariable Long id) throws RestException {
        return hrService.find(id.intValue());
    }

    @GetMapping("/get")
    public Employee findByIdParam(@RequestParam("id") Long id) throws RestException {
        return hrService.find(id.intValue());
    }


}
