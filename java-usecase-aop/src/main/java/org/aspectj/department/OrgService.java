package org.aspectj.department;

import org.aspectj.domain.Employee;

public interface OrgService {
    Employee getEmployee(Integer id);
    boolean deleteEmployee(Integer id);
}
