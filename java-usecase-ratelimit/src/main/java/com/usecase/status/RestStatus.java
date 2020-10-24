package com.usecase.status;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString()
public class RestStatus {
    private String message;
    private String errorCode;
    private HttpStatus statusCode;
    private Object data;

    public int getStatusCodeValue() {
        return this.statusCode == null ? 0 : this.statusCode.value();
    }
}
