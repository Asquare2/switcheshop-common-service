
package com.lgitsolution.switcheshopcommon.common.dto;


import java.util.List;

import lombok.Data;

/**
 * The Class ResponseWrapper.
 *
 * @param <T> the generic type
 */
@Data
public class ResponseWrapper<T> {
	
	public static final String KEY_STATUS = "status";

	/** The output. */
	private T output;

	/** The status. */
	private boolean status;

	/** The description. */
	private String description;

	/** The errors. */
	private List<String> errors;

	/**
	 * Instantiates a new response wrapper.
	 *
	 * @param output      the output
	 * @param status      the status
	 * @param description the description
	 * @param errors      the errors
	 */
	public ResponseWrapper(T output, boolean status, String description, List<String> errors) {
		super();
		this.output = output;
		this.status = status;
		this.description = description;
		this.errors = errors;
	}
}