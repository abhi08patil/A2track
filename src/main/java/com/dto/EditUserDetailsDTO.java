/**
 * 
 */
package com.dto;

import com.enums.StatusEnum;

/**
 * @author ashish.gupta
 *
 */
public class EditUserDetailsDTO {

	private Integer id;

	private String userNameEdit;
	
	private String nameEdit;

	private String emailIdEdit;

	private String userTypeEdit;

	private StatusEnum userStatusEdit;
	
	/** The DATEOFBIRTH field.*/
	private String dateOfBirth;

	
	/**
	 * Default constructor.
	 */
	public EditUserDetailsDTO() {
		super();
	}

	/**
	 * @param id
	 * @param userNameEdit
	 * @param emailIdEdit
	 * @param userTypeEdit
	 * @param userStatusEdit
	 * @param dateOfBirth
	 */
	public EditUserDetailsDTO(final String userNameEdit,
			final String emailIdEdit, final String userTypeEdit,final StatusEnum userStatusEdit,
			final String dateOfBirth) {
		super();
		this.userNameEdit = userNameEdit;
		this.emailIdEdit = emailIdEdit;
		this.userTypeEdit = userTypeEdit;
		this.userStatusEdit = userStatusEdit;
		this.dateOfBirth = dateOfBirth;
	}

	
	/**
	 * @param userNameEdit
	 * @param emailIdEdit
	 * @param dateOfBirth
	 */
	public EditUserDetailsDTO(final String nameEdit, final String emailIdEdit,
			final String dateOfBirth) {
		super();
		this.nameEdit = nameEdit;
		this.emailIdEdit = emailIdEdit;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the nameEdit
	 */
	public String getNameEdit() {
		return nameEdit;
	}

	/**
	 * @param nameEdit the nameEdit to set
	 */
	public void setNameEdit(String nameEdit) {
		this.nameEdit = nameEdit;
	}

	/**
	 * @return the userNameEdit
	 */
	public String getUserNameEdit() {
		return userNameEdit;
	}

	/**
	 * @param userNameEdit the userNameEdit to set
	 */
	public void setUserNameEdit(final String userNameEdit) {
		this.userNameEdit = userNameEdit;
	}

	/**
	 * @return the emailIdEdit
	 */
	public String getEmailIdEdit() {
		return emailIdEdit;
	}

	/**
	 * @param emailIdEdit the emailIdEdit to set
	 */
	public void setEmailIdEdit(final String emailIdEdit) {
		this.emailIdEdit = emailIdEdit;
	}

	/**
	 * @return the userTypeEdit
	 */
	public String getUserTypeEdit() {
		return userTypeEdit;
	}

	/**
	 * @param userTypeEdit the userTypeEdit to set
	 */
	public void setUserTypeEdit(final String userTypeEdit) {
		this.userTypeEdit = userTypeEdit;
	}

	/**
	 * @return the userStatusEdit
	 */
	public StatusEnum getUserStatusEdit() {
		return userStatusEdit;
	}

	/**
	 * @param userStatusEdit the userStatusEdit to set
	 */
	public void setUserStatusEdit(final StatusEnum userStatusEdit) {
		this.userStatusEdit = userStatusEdit;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(final String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
