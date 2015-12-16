/**
 * 
 */
package com.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRoleDao;
import com.model.UserRole;
import com.service.UserRoleService;


/**
 * @author ashish.gupta
 *
 */
@Service(UserRoleServiceImpl.SERVICE_NAME)
public class UserRoleServiceImpl implements UserRoleService{
	
	protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	UserRoleDao userRoleDao;
	/**
	 * Service Name.
	 */
	public static final String SERVICE_NAME = "userRoleService";

	public UserRole getUserRoleMasterById(Integer id) throws Exception {
		logger.debug("Inside getUserRoleMasterById method of UserRoleServiceImpl");
		return userRoleDao.getUserRoleMasterById(id);
	}

	/*	public UserRole getUserRoleDetails(UserRole userRole) throws Exception {
		System.out.println("Inside getUserRoleDetails method of UserRoleServiceImpl");
		return userRoleDao.getUserRoleDetails(userRole);
	}*/

}
