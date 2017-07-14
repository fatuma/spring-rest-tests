package com.worldline.fpl.recruitment.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Transaction entity.
 *
 * @author A525125
 */
@Data
public class Transaction implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 706690724306325415L;

	/** The id. */
	private String id;

	/** The account id. */
	private String accountId;

	/** The number. */
	private String number;

	/** The balance. */
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
	 * Gets the account id.
	 *
	 * @return the account id
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * Sets the account id.
	 *
	 * @param accountId the new account id
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
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
