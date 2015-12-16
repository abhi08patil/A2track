/**
 * 
 */
package com.enums;

/**
 * @author ashish.gupta
 *
 */
public enum StatusEnum {

	Inactive(0), Active(1),Pending(2),Approved(3),Suspended(4),Generated(5),Resolved(6);
	
	/**
	 * variable declaration
	 */
	private final Integer value;
	
	/**
	 * default constructor
	 */
	StatusEnum() {
		value = null;
	};

	/**
	 * Parameterized constructor
	 * @param value
	 */
	private StatusEnum(final Integer value) {
		this.value = value;
	}
	
	/**
	 * @return value
	 */

	public Integer getValue() {
		return value;
	}
}
