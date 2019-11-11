package orgx.spring.boot.controller;

import orgx.spring.boot.domain.Employee;
import orgx.spring.boot.service.hr.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orgx.spring.boot.exception.RestException;

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
