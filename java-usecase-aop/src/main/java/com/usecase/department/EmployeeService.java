package com.usecase.department;

import com.usecase.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmpService {

    @Override
    public Employee findById(Integer id) {
        return new Employee(id, "Employee-" + id, 20);
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
