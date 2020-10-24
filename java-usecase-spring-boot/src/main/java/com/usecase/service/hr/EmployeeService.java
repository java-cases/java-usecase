package com.usecase.service.hr;

import com.usecase.domain.Employee;
import com.usecase.exception.BadRequestException;
import com.usecase.exception.RestException;
import com.usecase.status.RestStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements HRService {

    @Override
    public Employee findEmployee(Integer id) throws RestException {
        if (id <= 0) {
            RestStatus status = RestStatus.builder()
                    .message("invalid id")
                    .errorCode("PM.0001.0001")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
            throw new BadRequestException(status);
        }

        return new Employee(id, "Employee-" + id, 18);
    }
}
