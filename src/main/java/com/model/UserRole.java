/**
 * 
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ashish.gupta
 *
 */
@Entity
@Table(name="user_roles")
public class UserRole {

	private Integer userRoleId;

	private User user;

	private String authority;
	
	public UserRole() {
		super();
	}
	
	/**
	 * @param user
	 * @param authority
	 */
	public UserRole(User user, String authority) {
		super();
		this.user = user;
		this.authority = authority;
	}

	@Id
	@GeneratedValue
	@Column(name = "USER_ROLE_ID", nullable = false)
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "AUTHORITY", length = 40)
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
