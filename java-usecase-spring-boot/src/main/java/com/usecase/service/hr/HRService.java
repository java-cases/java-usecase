package com.usecase.service.hr;


import com.usecase.domain.Employee;
import com.usecase.exception.HRServieException;

public interface HRService {
    Employee findEmployee(Integer id) throws HRServieException;
}
