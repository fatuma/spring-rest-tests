package com.worldline.fpl.recruitment.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Abstract transaction json representation.
 *
 * @author A525125
 */
@Data
public abstract class AbstractTransaction implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7866293071140304316L;

	/** The number. */
	@NotNull
	@ApiModelProperty(value = "Number", required = true)
	private String number;

	/** The balance. */
	@NotNull
	@ApiModelProperty(value = "Balance", required = true)
	private BigDecimal balance;

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
