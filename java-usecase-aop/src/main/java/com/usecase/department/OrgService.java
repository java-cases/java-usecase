package com.usecase.department;

import com.usecase.domain.Employee;

public interface OrgService {
    Employee getEmployee(Integer id);

    boolean deleteEmployee(Integer id);
}
