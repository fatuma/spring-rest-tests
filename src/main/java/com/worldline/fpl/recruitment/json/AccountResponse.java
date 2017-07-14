package com.worldline.fpl.recruitment.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Account json representation.
 *
 * @author A525125
 */
@Data
@ApiModel(value = "Account", description = "Account resource representation")
public class AccountResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1311670657098492357L;

	/** The id. */
	@NotNull
	@ApiModelProperty(value = "ID", required = true)
	private String id;

	/** The number. */
	@NotNull
	@ApiModelProperty(value = "Number", required = true)
	private String number;

	/** The type. */
	@NotNull
	@ApiModelProperty(value = "Type", required = true)
	private String type;

	/** The balance. */
	@NotNull
	@ApiModelProperty(value = "Balance", required = true)
	private BigDecimal balance;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
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
