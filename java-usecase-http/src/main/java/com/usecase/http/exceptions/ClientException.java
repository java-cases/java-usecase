
package com.usecase.http.exceptions;

import com.usecase.http.StatusCode;

public class ClientException extends ResponseException {

	private static final long serialVersionUID = 1L;

	private final StatusCode status;

	public ClientException(String message, StatusCode status, Throwable cause) {
		super(message, status, cause);
		this.status = status;
	}

	public ClientException(String message, StatusCode status) {
		super(message, status);
		this.status = status;;
	}

	public ClientException(String message, StatusCode status, String body) {
		super(message, status, body);
		this.status = status;
	}
}
