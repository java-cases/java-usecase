package com.usecase.hr.service.retry;

import com.usecase.exception.HRServieException;
import com.usecase.hr.model.Employee;
import com.usecase.status.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryableHRService implements RetryableService {

    private static final Logger log = LoggerFactory.getLogger(RetryableHRService.class);

    @Override
    @Retryable(value = HRServieException.class, maxAttempts = 3,
            backoff = @Backoff(delay = 1000, multiplier = 1))
    public Employee find(Integer id) throws HRServieException {
        log.info("to execute findEmployee.");

        if (id <= 0) {
            RestStatus status = RestStatus.builder()
                    .message("invalid id")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
            throw new HRServieException(status);
        }

        log.info("to complete findEmployee.");
        return new Employee(id, "Employee-" + id, 18);
    }

    @Recover
    public Employee recover(HRServieException e) {
        log.error(e.toString());

        return new Employee(0, "Employee-" + 0, 0);
    }
}
