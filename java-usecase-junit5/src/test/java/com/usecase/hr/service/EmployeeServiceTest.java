package com.usecase.hr.service;

import com.usecase.hr.model.Employee;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeServiceTest {

    @Autowired
    private HRService hrService;

    @DisplayName("find an employee by id")
    @Test
    public void findEmployee() {
        Employee employee = hrService.findEmployee(1001);

        assertThat(employee, Matchers.notNullValue());
        assertThat(employee.getId(), Matchers.is(1001));
    }

    @DisplayName("find an employee with invalid id")
    @Test
    public void findEmployeeWithInvalidId() {
        assertThrows(IllegalArgumentException.class,
                () -> hrService.findEmployee(-1));
    }
}