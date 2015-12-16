/**
 * 
 */
package com.dao;

import com.model.UserRole;

/**
 * @author ashish.gupta
 *
 */
public interface UserRoleDao {

	public void saveUserRoleDetails(UserRole userRole)  throws Exception;

	public UserRole getUserRoleMasterById(Integer id) throws Exception;
}
