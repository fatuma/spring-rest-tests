package com.worldline.fpl.recruitment.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Account details json representation.
 *
 * @author A525125
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel(value = "AccountDetails", description = "Account details resource representation")
public class AccountDetailsResponse extends AccountResponse implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6427772324577115079L;

	/** The creation date. */
	@NotNull
	@ApiModelProperty(value = "Creation date", required = true)
	private Date creationDate;

	/** The active. */
	@NotNull
	@ApiModelProperty(value = "Activation status of the account", required = true)
	private boolean active;

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
