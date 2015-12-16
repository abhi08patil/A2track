/**
 * 
 */
package com.controller;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.common.Constants;
import com.dto.EditUserDetailsDTO;
import com.dto.UserDTO;
import com.model.User;
import com.model.UserRole;
import com.service.SignUpService;
import com.service.UserService;

/**
 * @author ashish.gupta
 *
 */
@Controller
public class ManageUserConroller {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private SignUpService signUpService;

	@Autowired
	private UserService userService;


	private static String Welcome = "welcome";

	private static String WelcomeNew = "welcome.html";

	private static String PROFILE_DETAILS = "viewProfileDetails";


	/**
	 * @param userDTO as UserDTO
	 * @param request as HttpServletRequest
	 * @param response as HttpServletResponse
	 * @param principal as Principal
	 * @param ra
	 * @return
	 */
	@RequestMapping(value = "/addUser.html",method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDTO") UserDTO userDTO,
			HttpServletRequest request,HttpServletResponse response,Principal principal,RedirectAttributes ra) {
		logger.debug("Inside addUser of ManageUserConroller Starts");
		ModelAndView modelAndView=null;
		String name = principal.getName();
		try {
			int userId = signUpService.saveNewUserDetails(userDTO);
			UserRole userRole=new UserRole();
			User updatedUser=signUpService.getUserById(userId);
			userRole.setUser(updatedUser);
			if(userDTO.getUserType().equalsIgnoreCase(Constants.ADMIN)){
				userRole.setAuthority(Constants.AUTHORITY_ADMIN);	
			}else{
				userRole.setAuthority(Constants.AUTHORITY_USER);
			}
			signUpService.saveUserRoleDetails(userRole);
			List<User> users = userService.getListOfUsers();
			modelAndView=new ModelAndView(new RedirectView(WelcomeNew));
			ra.addFlashAttribute("usersList", users);
			ra.addFlashAttribute("author", name);
			//modelAndView.addObject("usersList", users);
			//modelAndView.addObject("author", name);
		} catch (Exception e) {
			logger.error("Exception occured"+ e.getMessage());
		}
		logger.debug("Inside addUser of ManageUserConroller Ends");
		return modelAndView;
	}

	/**
	 * @param editUserDetailsDTO
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/updateUser.html",method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("editUserDetailsDTO") EditUserDetailsDTO editUserDetailsDTO,
			HttpServletRequest request,HttpServletResponse response,Principal principal) {
		logger.debug("Inside updateUser of ManageUserConroller Starts");
		ModelAndView modelAndView=null;
		String name = principal.getName();
		try {
			int userId = signUpService.updateNewUserDetails(editUserDetailsDTO);
			UserRole userRole=new UserRole();
			User updatedUser=signUpService.getUserById(userId);
			userRole.setUser(updatedUser);
			if(editUserDetailsDTO.getUserTypeEdit().equalsIgnoreCase(Constants.ADMIN)){
				userRole.setAuthority(Constants.AUTHORITY_ADMIN);	
			}else{
				userRole.setAuthority(Constants.AUTHORITY_USER);
			}
			signUpService.saveUserRoleDetails(userRole);
			List<User> users = userService.getListOfUsers();
			modelAndView=new ModelAndView(Welcome);
			modelAndView.addObject("usersList", users);
			modelAndView.addObject("author", name);
		} catch (Exception e) {
			logger.error("Exception occured"+ e.getMessage());
		}
		logger.debug("Inside updateUser of ManageUserConroller Ends");
		return modelAndView;
	}

	@RequestMapping(value = "/updateProfile.html",method = RequestMethod.POST)
	public String updateUserProfile(@ModelAttribute("editUserDetailsDTO") EditUserDetailsDTO editUserDetailsDTO,
			HttpServletRequest request,HttpServletResponse response,Principal principal) {
		logger.debug("Inside updateUserProfile of ManageUserConroller Starts");
		boolean updateUserDetails =  false;
		try {
			updateUserDetails = userService.updateUserDetails(editUserDetailsDTO);
		} catch (Exception e) {
			logger.error("Exception occured"+ e.getMessage());
		}
		if(updateUserDetails){
			return "redirect:welcome.html";
		}
		logger.debug("Inside updateUserProfile of ManageUserConroller Ends");
		return "/updateProfile.html";
	}
	/**
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping("/viewProfileDetails.html")
	public ModelAndView viewProfileDetails(HttpServletRequest request,
			HttpServletResponse response,Principal principal){
		logger.debug("viewProfileDetails method of ManageUserConroller Starts");
		ModelAndView modelAndView = new ModelAndView(PROFILE_DETAILS); 
		try {
			User userDetails = userService.getUserDetails(principal.getName());
			modelAndView.addObject("userDetails", userDetails);
			modelAndView.addObject("author", principal.getName());
		} catch (Exception e) {
			logger.error("Exception occured"+ e.getMessage());
		}
		logger.debug("viewProfileDetails method of ManageUserConroller Ends");
		return modelAndView;
	}
}