/**
 * 
 */
package com.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.common.Constants;
import com.model.User;
import com.model.UserRole;
import com.service.UserRoleService;
import com.service.UserService;

/**
 * @author ashish.gupta
 *
 */
public class CustomAuthenticationManager implements AuthenticationManager {
	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	private UserService userService;

	@Autowired
	UserRoleService userRoleService;

	// We need an Md5 encoder since our passwords in the database are Md5 encoded. 
	private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		logger.debug("Inside authenticate method of CustomAuthenticationManager ");
		User user =null;

		try {
			user = userService.searchUserDetails(authentication.getName());
		} catch (Exception e) {
			logger.error("User does not exists!");
			throw new BadCredentialsException("User does not exists!");
		}
		// Compare passwords
		// Make sure to encode the password first before comparing
		if (passwordEncoder.isPasswordValid(user.getPassword(), (String) authentication.getCredentials(), null) == false ) {
			logger.error("Wrong password!");
			throw new BadCredentialsException("Wrong password!");
		}
		// Here's the main logic of this custom authentication manager
		// Username and password must be the same to authenticate
		if (authentication.getName().equals(authentication.getCredentials()) == true) {
			logger.debug("Entered username and password are the same!");
			throw new BadCredentialsException("Entered username and password are the same!");

		} else {

			logger.debug("User details are good and ready to go");
			return new UsernamePasswordAuthenticationToken(
					authentication.getName(), 
					authentication.getCredentials(), 
					getAuthorities(user.getUserId()));
		}
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
	 * Basically, this interprets the access value whether it's for a regular user or admin.
	 * 
	 * @param access an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer id) {
		logger.debug("Inside getAuthorities method of CustomAuthenticationManager ");
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		UserRole userRole=null;
		try {
			userRole=userRoleService.getUserRoleMasterById(id);
			StringBuffer functionalityName=new StringBuffer();

			// All users are granted with ROLE_USER access
			// Therefore this user gets a ROLE_USER by default
			if ( userRole.getAuthority().equalsIgnoreCase(Constants.AUTHORITY_ADMIN)) {
				// User has admin access
				logger.debug("Grant ROLE_ADMIN to this user");
				functionalityName.append(Constants.AUTHORITY_ADMIN);
			}else{
				logger.debug("Grant ROLE_USER to this user");
				functionalityName.append(Constants.AUTHORITY_USER);
			}
			authList.add(new SimpleGrantedAuthority(functionalityName.toString().toUpperCase()));
		} catch (Exception e) {
			logger.debug("Invalid Role");
			throw new BadCredentialsException("Role provided to user is invalid!");
		}
		// Return list of granted authorities
		return authList;
	}
}
