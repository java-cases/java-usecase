package com.usecase.department;

import com.usecase.hr.model.Employee;

public interface OrgService {
    Employee getEmployee(Integer id);

    boolean deleteEmployee(Integer id);
}
