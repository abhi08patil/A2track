/**
 * 
 */
package com.dao;

import java.util.List;

import com.dto.EditUserDetailsDTO;
import com.model.User;

/**
 * @author ashish.gupta
 *
 */
public interface UserDao {

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
	public List<User> getListOfUsers()throws Exception;

	/**
	 * @param assigned
	 * @return
	 * @throws Exception
	 */
	public User getUserByUserName(final String assigned) throws Exception;

	/**
	 * @param nameFinal
	 * @return
	 */
	public User getUserDetails(final String nameFinal);

	/**
	 * @param user
	 * @return 
	 */
	public boolean updateUserDetails(final User user);
}
