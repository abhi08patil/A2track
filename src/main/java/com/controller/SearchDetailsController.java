/**
 * 
 */
package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.common.Constants;
import com.controller.GenricController;
import com.service.SignUpService;

/**
 * @author ashish.gupta
 *
 */
@Controller
public class SearchDetailsController extends GenricController{
	
	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private SignUpService signUpService;

	@RequestMapping(value="/isUsernameAlreadyExists.html",method=RequestMethod.POST)
	public @ResponseBody String isUsernameAlreadyExists(@RequestParam(value = "username") String username){
		logger.debug("Inside isUserAlreadyExists of SearchDetailsController");
		boolean isUsernameAlreadyExists=false;
		String returnText = Constants.BLANK;
		if(username!=null && !"".equals(username)){	
			try {
				isUsernameAlreadyExists = signUpService.isUsernameAlreadyExists(username);
				if(isUsernameAlreadyExists){
					returnText = Constants.USER_UNAVAILABLE;	
				}else{
					returnText = Constants.USER_AVAILABLE;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}						
		}
		return returnText;
	}

	@RequestMapping(value="/isEmailIdAlreadyExists.html",method=RequestMethod.POST)
	public @ResponseBody String isEmailIdAlreadyExists(@RequestParam(value = "email") String email){

		logger.debug("Inside isEmailIdAlreadyExists of SearchDetailsController"+email);
		String returnText = " ";
		if(email!=null && !"".equals(email)){						
			boolean isUsernameAlreadyExists;
			try {
				isUsernameAlreadyExists = signUpService.isEmailIdAlreadyExists(email);

				if(isUsernameAlreadyExists){
					returnText = Constants.EMAIL_UNAVAILABLE;	
				}else{
					returnText = Constants.EMAIL_AVAILABLE;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnText;
	}
}
