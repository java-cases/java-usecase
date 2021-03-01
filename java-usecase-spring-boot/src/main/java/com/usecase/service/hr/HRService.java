package com.usecase.service.hr;


import com.usecase.config.DBSourceConfig;
import com.usecase.model.Employee;
import com.usecase.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;

public interface HRService {
    Employee findEmployee(Integer id) throws RestException;
    Employee getDefault() ;

    DBSourceConfig getDBSource();
}
