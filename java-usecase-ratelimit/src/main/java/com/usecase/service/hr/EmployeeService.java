package com.usecase.service.hr;

import com.usecase.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements HRService {

    @Override
    public Employee findEmployee(Integer id) {
        return new Employee(id, "Employee-" + id, 18);
    }
}
