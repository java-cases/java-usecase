package com.usecase.service.retry;


import com.usecase.model.Employee;
import com.usecase.exception.HRServieException;

public interface RetryableService {
    Employee findEmployee(Integer id) throws HRServieException;
}
