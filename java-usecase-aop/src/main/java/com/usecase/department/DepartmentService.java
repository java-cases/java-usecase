package com.usecase.department;

import com.usecase.annotation.MethodTraceLog;
import com.usecase.annotation.TraceLog;
import com.usecase.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements OrgService {

    @Override
    @TraceLog
    public Employee getEmployee(Integer id) {
        return new Employee(id, "Employee-" + id, 20);
    }

    @Override
    @MethodTraceLog
    public boolean deleteEmployee(Integer id) {
        return false;
    }
}
