/**
 * 
 */
package com.service;

import com.model.UserRole;

/**
 * @author ashish.gupta
 *
 */
public interface UserRoleService {

	/**
	 * This function fetched UserRole based on the Id
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public UserRole getUserRoleMasterById(Integer id) throws Exception;

	/*public UserRole getUserRoleDetails(UserRole userRole) throws Exception;*/

}
