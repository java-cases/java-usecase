package com.usecase.customer.service;

import com.usecase.config.DBSourceConfig;
import com.usecase.customer.model.Customer;
import com.usecase.exception.BadRequestException;
import com.usecase.exception.RestException;
import com.usecase.status.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    DBSourceConfig dbSourceConfig;

    @Value("${com.usecase.employee.name}")
    private String name;

    @Value("${com.usecase.employee.age}")
    private Integer age;

    @Override
    public Customer find(Integer id) throws RestException {
        if (id <= 0) {
            RestStatus status = RestStatus.builder()
                    .message("invalid id")
                    .errorCode("PM.0001.0001")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
            throw new BadRequestException(status);
        }

        return new Customer(id, "Employee-" + id, 18);
    }

    @Override
    public Customer getDefault() {
        return new Customer(0, this.name, this.age);
    }

    @Override
    public DBSourceConfig getDBSource() {
        return dbSourceConfig;
    }


}
