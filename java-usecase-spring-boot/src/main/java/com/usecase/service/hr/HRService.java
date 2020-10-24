package com.usecase.service.hr;


import com.usecase.domain.Employee;
import com.usecase.exception.RestException;

public interface HRService {
    Employee findEmployee(Integer id) throws RestException;
}
