package com.demo.controller;

import com.demo.domain.Employee;
import com.demo.exception.RestException;
import com.demo.service.hr.HRService;
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
    public Employee findById(@PathVariable Long id) throws RestException {
        if (id <= 0) {
            throw new RestException("invalid id!");
        }

        return hrService.findEmployee(id.intValue());
    }

    @GetMapping("/echo/{something}")
    public String echo(@PathVariable String something) {
        return something;
    }
}
