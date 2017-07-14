package com.worldline.fpl.recruitment.json;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.HttpStatus;

/**
 * Error code.
 *
 * @author A525125
 */
@AllArgsConstructor
public enum ErrorCode {

	/** The invalid account. */
	INVALID_ACCOUNT(HttpStatus.NOT_FOUND),
	INVALID_TRANSACTION_FOR_ACCOUNT(HttpStatus.NOT_FOUND),
	INVALID_TRANSACTION(HttpStatus.NOT_FOUND);

	/** The http status. */
	@Getter
	private HttpStatus httpStatus;

	/**
	 * Instantiates a new error code.
	 *
	 * @param httpStatus the http status
	 */
	private ErrorCode(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Sets the http status.
	 *
	 * @param httpStatus the new http status
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
