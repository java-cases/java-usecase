package com.usecase.service.hr;

import com.usecase.domain.Employee;
import com.usecase.exception.HRServieException;
import com.usecase.status.ServiceStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements HRService {

    @Override
    public Employee findEmployee(Integer id) throws HRServieException {
        if (id <= 0) {
            ServiceStatus status = ServiceStatus.builder()
                    .message("invalid id")
                    .errorCode("PM.0001.0001")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            throw new HRServieException(status);
        }

        return new Employee(id, "Employee-" + id, 18);
    }
}
