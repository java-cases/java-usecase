package orgx.spring.boot.service.retry;

import org.junit.Test;
import org.junit.runner.RunWith;
import orgx.spring.boot.domain.Employee;
import orgx.spring.boot.exception.HRServieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class RetryableHRServiceTest {

    @Autowired
    private RetryableService retryableService;

    @Test
    public void findEmployee() throws HRServieException {
        Employee employee = retryableService.findEmployee(1002);

        assertNotNull(employee);
        System.out.println(employee);

        assertEquals(true, employee.getId() == 1002);
    }

    @Test
    public void findEmployeeInvalidID() throws HRServieException {
        Employee employee = retryableService.findEmployee(-1);

        assertNotNull(employee);
        System.out.println(employee);

        assertEquals(true, employee.getId() == 0);
    }
}