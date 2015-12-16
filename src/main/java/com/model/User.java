/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import com.enums.StatusEnum;

/**
 * @author ashish.gupta
 *
 */
@Entity
@Table(name="users")
public class User implements Serializable {

	/** Generated serialVersionUID.*/
	private static final long serialVersionUID = -4082151066314749786L;

	/** The USER_ID field.*/
	private Integer userId;

	/** The USERNAME field.*/
	private String userName;

	/** The PASSWORD field.*/
	private String password;

	/** The NAME field.*/
	private String name;

	/** The EMAIL field.*/
	private String email;

	/** The DATEOFBIRTH field.*/
	private String dateOfBirth;

	/** The ACTIVE field.*/
	private StatusEnum status;
	
	/** The ROLE_PROVIDED_BY_ADMIN field.*/
	private String roleAdmin;
	
	/** The FILENAME field.*/
	private String filename;
	
	/** The CONTENT field.*/
	private byte[] content;
	    
	/** The CONTENT_TYPE field.*/
	private String contentType;


	/** Default Constructor.*/
	public User() {
	}

	/**
	 * @param userName
	 * @param password
	 * @param name
	 * @param email
	 * @param dateOfBirth
	 * @param status
	 * @param roleAdmin
	 * @param filename
	 * @param content
	 * @param contentType
	 */
	public User(String userName, String password, String name,
			String email, String dateOfBirth, StatusEnum status,
			String roleAdmin, String filename, byte[] content,
			String contentType) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
		this.roleAdmin = roleAdmin;
		this.filename = filename;
		this.content = content;
		this.contentType = contentType;
	}



	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false)
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "USERNAME", length = 40)
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD", length = 500)
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NAME", length = 45)
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EMAIL", length = 45)	
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "DATEOFBIRTH", length = 45)	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@Column(name = "ACTIVE", length = 50)
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "ROLE_PROVIDED_BY_ADMIN", length = 50)
	public String getRoleAdmin() {
		return roleAdmin;
	}

	/**
	 * @param roleAdmin the roleAdmin to set
	 */
	public void setRoleAdmin(String roleAdmin) {
		this.roleAdmin = roleAdmin;
	}

	/**
	 * @return the filename
	 */
	@Column(name="FILENAME" , length = 200)
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}


	/**
	 * @return the content
	 */
	@Column(name="CONTENT" , length = 400)
	@Lob
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	/**
	 * @return the contentType
	 */
	@Column(name="CONTENT_TYPE" , length = 200)
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(content);
		result = prime * result
				+ ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((roleAdmin == null) ? 0 : roleAdmin.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (!Arrays.equals(content, other.content))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleAdmin == null) {
			if (other.roleAdmin != null)
				return false;
		} else if (!roleAdmin.equals(other.roleAdmin))
			return false;
		if (status != other.status)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", name=" + name + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + ", status=" + status
				+ ", roleAdmin=" + roleAdmin + ", filename=" + filename
				+ ", content=" + Arrays.toString(content) + ", contentType="
				+ contentType + "]";
	}

}
