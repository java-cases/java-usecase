package com.usecase.service.hr;

import com.usecase.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeServiceTest {

    @Autowired
    private HRService hrService;

    @Test
    public void findEmployee() {
        Employee employee = hrService.findEmployee(1001);

        assertNotNull(employee);
        System.out.println(employee);

        assertEquals(true, employee.getId() == 1001);
    }
}