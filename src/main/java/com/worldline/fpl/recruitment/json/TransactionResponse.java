package com.worldline.fpl.recruitment.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Transaction json representation.
 *
 * @author A525125
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel(value = "Transaction", description = "Transaction resource representation")
public class TransactionResponse extends AbstractTransaction implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2371720864101586328L;

	/** The id. */
	@NotNull
	@ApiModelProperty(value = "ID", required = true)
	private String id;

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
	
	

}
