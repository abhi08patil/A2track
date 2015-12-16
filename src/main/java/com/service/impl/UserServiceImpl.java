/**
 * 
 */
package com.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.StringUtils;
import com.dao.SignUpDao;
import com.dao.UserDao;
import com.dto.EditUserDetailsDTO;
import com.model.User;
import com.service.UserService;

/**
 * @author ashish.gupta
 *
 */
@Service(UserServiceImpl.SERVICE_NAME)
public class UserServiceImpl implements UserService {
	protected static Logger logger = Logger.getLogger("service");

	/**
	 * Service Name.
	 */
	public static final String SERVICE_NAME = "userService";

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SignUpDao signUpDao;

	/* (non-Javadoc)
	 * @see com.service.UserService#searchUserDetails(java.lang.String)
	 */
	public User searchUserDetails(final String name) throws Exception {
		logger.debug("Inside searchUserDetails method of UserServiceImpl");
		return userDao.searchUserDetails(name);
	}

	/* (non-Javadoc)
	 * @see com.service.UserService#getListOfUsers()
	 */
	public List<User> getListOfUsers() throws Exception {
		logger.debug("Inside getListOfUsers method of UserServiceImpl");
		return userDao.getListOfUsers();
	}

	/* (non-Javadoc)
	 * @see com.service.UserService#getUserByUserName(java.lang.String)
	 */
	public User getUserByUserName(final String doneBy) throws Exception {
		logger.debug("Inside getUserByUserName method of UserServiceImpl");
		String assigned= StringUtils.splitComma(doneBy);
		return userDao.getUserByUserName(assigned);
	}

	/* (non-Javadoc)
	 * @see com.service.UserService#getUserDetails(java.lang.String)
	 */
	public User getUserDetails(final String name) throws Exception {
		logger.debug("Inside getUserDetails method of UserServiceImpl");
		String nameFinal= StringUtils.splitComma(name);
		return userDao.getUserDetails(nameFinal);
	}
	
	@Transactional
	public boolean updateUserDetails(EditUserDetailsDTO editUserDetailsDTO)
			throws Exception {
		logger.debug("Inside updateUserDetails of UserServiceImpl Starts");
		User user = userDao.getUserByUserName(editUserDetailsDTO.getUserNameEdit());
		if (editUserDetailsDTO.getNameEdit() != null
				&& !editUserDetailsDTO.getNameEdit().isEmpty()) {
			String name= StringUtils.splitComma(editUserDetailsDTO.getNameEdit());
			user.setName(name);
		}
		if (editUserDetailsDTO.getEmailIdEdit() != null
				&& !editUserDetailsDTO.getEmailIdEdit().isEmpty()) {
			String email= StringUtils.splitComma(editUserDetailsDTO.getEmailIdEdit());
			user.setEmail(email);
		}
		if (editUserDetailsDTO.getDateOfBirth() != null
				&& !editUserDetailsDTO.getDateOfBirth().isEmpty()) {
			String dateOfBirth= StringUtils.splitComma(editUserDetailsDTO.getDateOfBirth());
			user.setDateOfBirth(dateOfBirth);
		}	
		return userDao.updateUserDetails(user);	
	}
}
