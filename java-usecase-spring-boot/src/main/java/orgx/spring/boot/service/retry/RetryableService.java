package orgx.spring.boot.service.retry;


import orgx.spring.boot.domain.Employee;
import orgx.spring.boot.exception.HRServieException;

public interface RetryableService {
    Employee findEmployee(Integer id) throws HRServieException;
}
