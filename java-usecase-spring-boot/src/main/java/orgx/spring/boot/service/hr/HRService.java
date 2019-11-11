package orgx.spring.boot.service.hr;


import orgx.spring.boot.domain.Employee;

public interface HRService {
    Employee findEmployee(Integer id);
}
