package org.aspectj.department;

import org.aspectj.annotation.MethodTraceLog;
import org.aspectj.annotation.TraceLog;
import org.aspectj.domain.Employee;
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
