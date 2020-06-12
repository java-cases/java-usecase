package com.usecase.department;

import com.usecase.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class DepartmentServiceTest {

    @Autowired
    private OrgService orgService;

    @Test
    public void getEmployee() {
        Employee employee = orgService.getEmployee(1002);

        assertNotNull(employee);
        System.out.println(employee);

        assertEquals(true, employee.getId() == 1002);
    }

    @Test
    public void deleteEmployee() {
        boolean result = orgService.deleteEmployee(1003);

        assertFalse(result);
    }
}