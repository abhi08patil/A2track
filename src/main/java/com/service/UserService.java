/**
 * 
 */
package com.service;

import java.util.List;

import com.dto.EditUserDetailsDTO;
import com.model.User;

/**
 * @author ashish.gupta
 *
 */
public interface UserService {

	/**
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public User searchUserDetails(final String name) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	public List<User> getListOfUsers() throws Exception;

	/**
	 * @param doneBy
	 * @return
	 * @throws Exception
	 */
	public User getUserByUserName(final String doneBy) throws Exception;

	/**
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	public User getUserDetails(final String name) throws Exception;

	/**
	 * @param editUserDetailsDTO
	 * @throws Exception
	 */
	public boolean updateUserDetails(final EditUserDetailsDTO editUserDetailsDTO)throws Exception;
	
}
