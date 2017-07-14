package com.worldline.fpl.recruitment.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Error response.
 *
 * @author A525125
 */
@Data
@AllArgsConstructor
@ApiModel(value = "ErrorResponse", description = "Error resource representation")
public class ErrorResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4372672070020226566L;

	/** The error code. */
	@NotNull
	@ApiModelProperty(value = "Error code", required = true, example = "<errorcode>", dataType = "java.lang.String")
	private ErrorCode errorCode;

	/** The error message. */
	@ApiModelProperty(value = "Error message")
	private String errorMessage;

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new error response.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 */
	public ErrorResponse(ErrorCode errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
}
