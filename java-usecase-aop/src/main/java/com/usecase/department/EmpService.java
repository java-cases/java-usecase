package com.usecase.department;

import com.usecase.model.Employee;

public interface EmpService {
    Employee findById(Integer id);

    boolean deleteById(Integer id);
}
