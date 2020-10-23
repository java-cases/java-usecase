package com.usecase.controller;

import com.usecase.annotation.RateLimit;
import com.usecase.domain.Employee;
import com.usecase.exception.RestException;
import com.usecase.service.hr.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenly
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private HRService hrService;

    @GetMapping("/{id}")
    @RateLimit(perSecond = 1.0, timeOut = 500)
    public Employee findById(@PathVariable Long id) throws RestException {
        return hrService.findEmployee(id.intValue());
    }

    @GetMapping("/echo/{something}")
    public String echo(@PathVariable String something) {
        return something;
    }
}
