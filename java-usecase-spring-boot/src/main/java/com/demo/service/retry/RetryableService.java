package com.demo.service.retry;


import com.demo.domain.Employee;
import com.demo.exception.HRServieException;

public interface RetryableService {
    Employee findEmployee(Integer id) throws HRServieException;
}
