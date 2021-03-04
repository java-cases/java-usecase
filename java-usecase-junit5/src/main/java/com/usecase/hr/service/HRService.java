package com.usecase.hr.service;


import com.usecase.hr.model.Employee;

public interface HRService {
    Employee findEmployee(Integer id);
}
