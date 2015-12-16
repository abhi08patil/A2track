/**
 * 
 */
package com.service;


import com.dto.EditUserDetailsDTO;
import com.dto.UserDTO;
import com.model.User;
import com.model.UserRole;

/**
 * @author ashish.gupta
 *
 */
public interface SignUpService {
	
	
	public int saveUserDetails(User user) throws Exception;

	public User getUserById(int userId);

	public void saveUserRoleDetails(UserRole userRole)throws Exception;
	
	public boolean isUsernameAlreadyExists(String username)throws Exception;

	public boolean isEmailIdAlreadyExists(String email) throws Exception;

	public int saveNewUserDetails(UserDTO userDTO)throws Exception;	
	
	public int updateNewUserDetails(EditUserDetailsDTO editUserDetailsDTO)throws Exception;	

}
