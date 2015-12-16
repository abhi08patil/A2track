/**
 * 
 */
package com.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.Constants;
import com.common.StringUtils;
import com.dao.SignUpDao;
import com.dao.UserRoleDao;
import com.dto.EditUserDetailsDTO;
import com.dto.UserDTO;
import com.model.User;
import com.model.UserRole;
import com.service.SignUpService;

/**
 * @author ashish.gupta
 *
 */
@Service(SignUpServiceImpl.SERVICE_NAME)
public class SignUpServiceImpl implements SignUpService {

	protected static Logger logger = Logger.getLogger("service");
	/**
	 * Service Name.
	 */
	public static final String SERVICE_NAME = "signUpService";

	@Autowired
	private SignUpDao signUpDao;

	@Autowired
	private UserRoleDao userRoleDao;

	/* (non-Javadoc)
	 * @see com.service.SignUpService#saveUserDetails(com.model.User)
	 */
	@Transactional
	public int saveUserDetails(User user) throws Exception {
		logger.debug("Inside saveUserDetails of SignUpServiceImpl");
		try {
			return signUpDao.saveUserDetails(user);
		} catch (Exception exception) {					
			logger.debug("Exception occured :"+exception.getMessage());
		}
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.service.SignUpService#getUserById(int)
	 */
	public User getUserById(int userId){
		logger.debug("Inside getUserById of SignUpServiceImpl");
		try {
			return signUpDao.getUserById(userId);
		} catch (Exception exception) {					
			logger.debug("Exception occured :"+exception.getStackTrace());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.SignUpService#saveUserRoleDetails(com.model.UserRole)
	 */
	@Transactional
	public void saveUserRoleDetails(UserRole userRole) throws Exception {
		logger.debug("Inside saveUserRoleDetails of SignUpServiceImpl");
		try {
			userRoleDao.saveUserRoleDetails(userRole);
		} catch (Exception exception) {					
			logger.debug("Exception occured :"+exception.getStackTrace());
		}
	}

	/* (non-Javadoc)
	 * @see com.service.SignUpService#isUsernameAlreadyExists(java.lang.String)
	 */
	public boolean isUsernameAlreadyExists(String username) throws Exception {
		logger.debug("Inside isUsernameAlreadyExists of SignUpServiceImpl");
		try {
			return signUpDao.isUsernameAlreadyExists(username);
		} catch (Exception exception) {					
			logger.debug("Exception occured :"+exception);
			return false;
		}				
	}


	/* (non-Javadoc)
	 * @see com.service.SignUpService#isEmailIdAlreadyExists(java.lang.String)
	 */
	public boolean isEmailIdAlreadyExists(String email) throws Exception {
		logger.debug("Inside isUsernameAlreadyExists of SignUpServiceImpl");
		try {
			return signUpDao.isEmailIdAlreadyExists(email);
		} catch (Exception exception) {					
			logger.debug("Exception occured :"+exception);
			return false;
		}			
	}


	/* (non-Javadoc)
	 * @see com.service.SignUpService#saveNewUserDetails(com.dto.UserDTO)
	 */
	@Transactional
	public int saveNewUserDetails(UserDTO userDTO) throws Exception {
		logger.debug("Inside saveNewUserDetails of SignUpServiceImpl Starts");
		String hashedPassword = StringUtils.getHashPaswordValues(Constants.DEFAULT_PASSWORD);
		String dateOfBirth= StringUtils.getDateFormat();

		User user= 
				new User(userDTO.getUserName(),hashedPassword,userDTO.getUserName(),
						userDTO.getEmailId(),dateOfBirth,userDTO.getUserStatus(),userDTO.getUserType()
						,userDTO.getFile().getOriginalFilename(),userDTO.getFile().getBytes(),
						userDTO.getFile().getContentType());
		logger.debug("Inside saveNewUserDetails of SignUpServiceImpl Ends");	
		return signUpDao.saveUserDetails(user);
	}

	/* (non-Javadoc)
	 * @see com.service.SignUpService#updateNewUserDetails(com.dto.EditUserDetailsDTO)
	 */
	@Transactional
	public int updateNewUserDetails(EditUserDetailsDTO editUserDetailsDTO)
			throws Exception {
		logger.debug("Inside saveNewUserDetails of SignUpServiceImpl Starts");
		User user = signUpDao.getUserByUserName(editUserDetailsDTO.getUserNameEdit());
		if (editUserDetailsDTO.getUserNameEdit() != null
				&& !editUserDetailsDTO.getUserNameEdit().isEmpty()) {
			String name= StringUtils.splitComma(editUserDetailsDTO.getUserNameEdit());
			user.setName(name);
		}
		if (editUserDetailsDTO.getEmailIdEdit() != null
				&& !editUserDetailsDTO.getEmailIdEdit().isEmpty()) {
			String email= StringUtils.splitComma(editUserDetailsDTO.getEmailIdEdit());
			user.setEmail(email);
		}
		if (editUserDetailsDTO.getUserStatusEdit() != null) {
			user.setStatus(editUserDetailsDTO.getUserStatusEdit());
		}
		if (editUserDetailsDTO.getUserTypeEdit() != null
				&& !editUserDetailsDTO.getUserTypeEdit().isEmpty()) {
			String role= StringUtils.splitComma(editUserDetailsDTO.getUserTypeEdit());
			user.setRoleAdmin(role);
		}	
		return signUpDao.saveUserDetails(user);
	}

}