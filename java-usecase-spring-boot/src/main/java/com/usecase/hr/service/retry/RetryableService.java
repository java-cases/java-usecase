package com.usecase.hr.service.retry;


import com.usecase.exception.HRServieException;
import com.usecase.hr.model.Employee;

public interface RetryableService {
    Employee find(Integer id) throws HRServieException;
}
