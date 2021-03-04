package com.usecase.hr.service;


import com.usecase.config.DBSourceConfig;
import com.usecase.exception.RestException;
import com.usecase.hr.model.Employee;

public interface HRService {
    Employee find(Integer id) throws RestException;

    Employee getDefault();

    DBSourceConfig getDBSource();
}
