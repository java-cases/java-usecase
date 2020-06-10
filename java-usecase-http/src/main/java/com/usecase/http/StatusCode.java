
package com.usecase.http;

public enum StatusCode 
{
	OK(200),

	// Client Status Codes
	BAD_REQUEST(400),
	UNAUTHORIZED(401),
	PAYMENT_REQUIRED(402),
	FORBIDDEN(403),
	NOT_FOUND(404),
	METHOD_NOT_ALLOWED(405),
	NOT_ACCEPTABLE(406),
	PROXY_AUTH_REQUIRED(407),
	REQUEST_TIMEOUT(408),
	CONFLICT(409),
	GONE(410),
	LENGTH_REQUIRED(411),
	PRE_CONDITION_FAILED(412),
	REQUEST_ENTITY_TOO_LARGE(413),
	REQUEST_URI_TOO_LONG(414),
	UNSUPPORTED_MEDIATYPE(415),
	REQUESTED_RANGE_NOT_SATISFIABLE(416),
	EXPECTATION_FAILED(417),
	UNPROCESSABLE_ENTITY(422),
	
	//Server Status Code
	INTERNAL_SERVER_ERROR(500),
	NOT_IMPLEMENTED(501),
	BAD_GATEWAY(502),
	SERVICE_UNAVAILABLE(503),
	GATEWAY_TIMEOUT(504),
	VERSION_NOT_SUPPORTED(505),

	UNKNOWN_CODE(0);

	private final int code;

	private StatusCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusCode from(int code) {
		for (StatusCode codes : StatusCode.values())
		{
			if (codes.getCode() == code) {
				return codes;
			}
		}

		return UNKNOWN_CODE;
	}
}
