package com.worldline.fpl.recruitment.exception;

import lombok.Getter;

import com.worldline.fpl.recruitment.json.ErrorCode;

/**
 * Service exception.
 *
 * @author A525125
 */
public class ServiceException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8303256484065597037L;

	/** The error code. */
	@Getter
	private final ErrorCode errorCode;

	/** The message. */
	@Getter
	private final String message;

	/**
	 * Instantiates a new service exception.
	 *
	 * @param errorCode the error code
	 */
	public ServiceException(ErrorCode errorCode) {
		this(errorCode, null);
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public ServiceException(ErrorCode errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	
}
