/**
 * 
 */
package com.dao;

import com.model.User;


/**
 * @author ashish.gupta
 *
 */
public interface SignUpDao {

	public int saveUserDetails(User user) throws Exception;

	public User getUserById(int userId);
	
	public User getUserByUserName(String name);

	public boolean isUsernameAlreadyExists(String username)throws Exception;

	public boolean isEmailIdAlreadyExists(String emailId) throws Exception;

	
}
