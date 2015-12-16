package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.common.StringUtils;
import com.common.Constants;
import com.dto.SignUpDTO;
import com.enums.StatusEnum;
import com.model.User;
import com.model.UserRole;
import com.service.SignUpService;

/**
 * @author Ashish gupta
 *
 */
@Controller
public class LoginController extends GenricController{

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private SignUpService signUpService;

	private static String SignUp = "signup";
	private static String Login = "login";
	//private static String Welcome = "welcome";

	/*@RequestMapping(value="/index", method = RequestMethod.GET)
	public String executeSecurity(ModelMap model, Principal principal ) {
		System.out.println("Inside executeSecurity method of LoginController Starts");
		String name = principal.getName();
		model.addAttribute("author", name);
		System.out.println("Inside executeSecurity method of LoginController Ends");
		return Welcome;
	}*/
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.html")
	public ModelAndView initLogin(HttpServletRequest request,
			HttpServletResponse response){
		logger.debug("initLogin method of LoginController Starts");
		ModelAndView modelAndView = new ModelAndView(Login);    
		logger.debug("Erorr:"+(request.getParameter(Constants.ERROR)));
		if(StringUtils.emptyAndNullCheckString((request.getParameter(Constants.ERROR))) && 
				(request.getParameter(Constants.ERROR)).equals(Constants.TRUE))
			modelAndView.addObject(Constants.ERROR, Constants.TRUE);
		logger.debug("initLogin method of LoginController Ends");
		return modelAndView;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/sessionTimeout.html")
	public ModelAndView sessionTimeout(HttpServletRequest request,
			HttpServletResponse response){
		logger.debug("sessionTimeout method of LoginController Starts");
		ModelAndView modelAndView = new ModelAndView(Login);    
		//modelAndView.addObject("sessionTimeout", Constants.TRUE);
		logger.debug("sessionTimeout method of LoginController Ends");
		return modelAndView;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return Login;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/loggedOut.html")
	public ModelAndView loggedOut(HttpServletRequest request,
			HttpServletResponse response){
		logger.debug("loggedOut method of LoginController Starts");
		ModelAndView modelAndView = new ModelAndView(Login);    
		//modelAndView.addObject("logout", Constants.TRUE);
		logger.debug("loggedOut method of LoginController Ends");
		return modelAndView;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/initSignup.html")
	public ModelAndView initSignup(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("Inside initSignup method of LoginController Starts");
		ModelAndView modelAndView = new ModelAndView(SignUp);
		return modelAndView;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/initSignin.html")
	public ModelAndView initSignin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("Inside InitSignin method of LoginController Starts");
		ModelAndView modelAndView = new ModelAndView(Login);
		return modelAndView;
	}


	/**
	 * @param signUpDTO
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/signUpForm.html")
	public ModelAndView signUpForm(SignUpDTO signUpDTO,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		logger.debug("Inside signUpForm method of  LoginController Starts");
		User user= new User();
		String hashedPassword = StringUtils.getHashPaswordValues(signUpDTO.getPassword());
		user.setUserName(signUpDTO.getUsername());
		user.setName(signUpDTO.getName());
		user.setPassword(hashedPassword);
		user.setEmail(signUpDTO.getEmail());
		user.setDateOfBirth(signUpDTO.getDateofbirth());
		user.setStatus(StatusEnum.Active);

		int userId=signUpService.saveUserDetails(user);
		UserRole userRole=new UserRole();
		User updatedUser=signUpService.getUserById(userId);
		userRole.setUser(updatedUser);
		userRole.setAuthority(Constants.AUTHORITY_USER);
		signUpService.saveUserRoleDetails(userRole);
		logger.debug("Inside signUpForm method of  LoginController Ends");
		ModelAndView modelAndView = new ModelAndView(Login);
		return modelAndView;
	}


}
