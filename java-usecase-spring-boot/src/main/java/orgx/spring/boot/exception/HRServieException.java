package orgx.spring.boot.exception;

import orgx.spring.boot.status.ServiceStatus;

public class HRServieException extends RestException {

    public HRServieException(ServiceStatus status) {
        super(status);
    }
}
