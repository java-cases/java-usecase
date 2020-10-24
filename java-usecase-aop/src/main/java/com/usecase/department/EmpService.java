package com.usecase.department;

import com.usecase.domain.Employee;

public interface EmpService {
    Employee findById(Integer id);

    boolean deleteById(Integer id);
}
