package com.usecase.department;

import com.usecase.annotation.TraceLogMethod;
import com.usecase.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements OrgService {

    @Override
    @TraceLogMethod
    public Employee getEmployee(Integer id) {
        return new Employee(id, "Employee-" + id, 20);
    }

    @Override
    @TraceLogMethod
    public boolean deleteEmployee(Integer id) {
        return false;
    }
}
