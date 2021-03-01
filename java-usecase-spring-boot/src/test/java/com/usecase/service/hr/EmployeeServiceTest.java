package com.usecase.service.hr;

import com.usecase.model.Employee;
import com.usecase.exception.RestException;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeServiceTest {

    @Autowired
    private HRService hrService;

    @Test
    public void findEmployee() throws RestException {
        Employee employee = hrService.findEmployee(1001);

        assertThat(employee, Matchers.notNullValue());
        System.out.println(employee);

        assertThat(employee.getId(), Matchers.is(1001));
    }

    @Test
    public void getDefault() {
        Employee employee = hrService.getDefault();

        assertThat(employee, Matchers.notNullValue());
        System.out.println(employee);

        assertThat(employee.getId(), Matchers.is(0));
        assertThat(employee.getName(), Matchers.is("demo"));
        assertThat(employee.getAge(), Matchers.is(19));
    }

    @Test
    public void findEmployeeWithInvalidId() {
        RestException e = assertThrows(RestException.class, () -> {
            hrService.findEmployee(0);
        });

        assertNotNull(e);
        System.out.println(e.getStatus());

        assertEquals(HttpStatus.BAD_REQUEST, e.getStatus().getStatusCode());
    }
}