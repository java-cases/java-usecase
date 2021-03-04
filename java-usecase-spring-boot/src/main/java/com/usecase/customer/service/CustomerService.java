package com.usecase.customer.service;


import com.usecase.config.DBSourceConfig;
import com.usecase.customer.model.Customer;
import com.usecase.exception.RestException;

public interface CustomerService {
    Customer find(Integer id) throws RestException;

    Customer getDefault();

    DBSourceConfig getDBSource();
}
