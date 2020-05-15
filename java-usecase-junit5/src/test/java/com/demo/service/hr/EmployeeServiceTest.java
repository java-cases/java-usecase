package com.demo.service.hr;

import com.demo.domain.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

        assertNotNull(employee);
        assertEquals(1001, (int) employee.getId());
    }

    @DisplayName("find an employee with invalid id")
    @Test
    public void findEmployeeWithInvalidId() {
        assertThrows(IllegalArgumentException.class,
                () -> hrService.findEmployee(-1));
    }
}