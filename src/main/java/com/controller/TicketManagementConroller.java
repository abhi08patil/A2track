/**
 * 
 */
package com.controller;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.common.Constants;
import com.dto.ReportDTO;
import com.enums.StatusEnum;
import com.model.TicketDetailsMaster;
import com.model.User;
import com.service.SignUpService;
import com.service.TicketDetailsService;
import com.service.TicketUserMappingService;
import com.service.UserService;


/**
 * @author ashish.gupta
 *
 */
@Controller
public class TicketManagementConroller {

	protected static Logger logger = Logger.getLogger("controller");

	private static String Welcome = "welcome";
	private static String WelcomeNew = "welcome.html";
	private static String MANAGE_TICKET = "manageTicket";
	private static String SUMMARY_GRID = "summary";

	@Autowired
	private TicketDetailsService ticketDetailsService;

	@Autowired
	private TicketUserMappingService ticketUserMappingService;

	@Autowired
	private UserService userService;

	@Autowired
	private SignUpService signUpService;

	/**
	 * 
	 * @param reportDTO
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/initReportTicket.html",method = RequestMethod.POST)
	public ModelAndView addTicket(@ModelAttribute("reportDTO") ReportDTO reportDTO,
			HttpServletRequest request,HttpServletResponse response, Principal principal,RedirectAttributes ra) {
		logger.debug("Inside addTicket of TicketManagementConroller Starts");
		ModelAndView modelAndView=null;
		try {
			reportDTO.setStatus(Constants.OPEN);
			//reportDTO.setDoneBy(Constants.NOT_ASSGN);
			reportDTO.setActive(StatusEnum.Active);
			reportDTO.setRequestedBy(principal.getName());
			ticketDetailsService.saveTicketDetails(reportDTO);
			String name = principal.getName();
			modelAndView = new ModelAndView(new RedirectView(WelcomeNew));
			ra.addFlashAttribute("author", name);
			//modelAndView.addObject("author", name);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside addTicket of TicketManagementConroller Ends");
		return modelAndView;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/manageTicket.html")
	public ModelAndView manageTicket(HttpServletRequest request,HttpServletResponse response,Principal principal) {
		logger.debug("Inside manageTicket of TicketManagementConroller Starts");
		ModelAndView modelAndView = new ModelAndView(MANAGE_TICKET);
		try {
			List<TicketDetailsMaster> ticketDetailsMasters = ticketDetailsService.getAllTicketDetails();
			List<User> users = userService.getListOfUsers();
			modelAndView.addObject("usersList", users);
			String name = principal.getName();
			modelAndView.addObject("ticketDetailsList", ticketDetailsMasters);
			modelAndView.addObject("author", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/welcome.html")
	public ModelAndView viewWelcome(HttpServletRequest request,HttpServletResponse response,Principal principal ) {
		logger.debug("Inside viewWelcome of TicketManagementConroller Starts");
		String challenge = request.getParameter("recaptcha_challenge_field");
		String response2 = request.getParameter("recaptcha_response_field");
		String remoteAddr = request.getRemoteAddr();
		logger.debug(challenge+":"+response2+":"+remoteAddr);
		ModelAndView modelAndView = null;
		try {
			String name = principal.getName();
			List<User> users = userService.getListOfUsers();
			modelAndView=new ModelAndView(Welcome);
			modelAndView.addObject("usersList", users);
			modelAndView.addObject("author", name);
			//User userDetails = userService.getUserDetails(principal.getName());

			/*String imageName = "userAvatar";
			response.setContentType("image/jpeg");
			response.setContentLength(userDetails.getContent().length);
			response.setHeader("Content-Disposition", "inline; filename=\"" + name
					+ "\"");
			BufferedInputStream input = null;
			BufferedOutputStream output = null;
			input = new BufferedInputStream(new ByteArrayInputStream(userDetails.getContent()));
			output = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[8192];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside viewWelcome of TicketManagementConroller Ends");
		return modelAndView;

	}

	/**
	 * @param deleteId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteTicket.html", method = RequestMethod.POST)
	public String deleteProduct(@RequestParam(value = "deleteId") Integer deleteId,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.debug("Inside deleteProduct of TicketManagementConroller Starts:"+deleteId);
		ticketDetailsService.deleteTicket(deleteId);
		return "redirect:manageTicket.html";

	}
	/**
	 * 
	 * @param reportDTO
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateTicket.html",method = RequestMethod.POST)
	public String updateTicket(@ModelAttribute("reportDTO") ReportDTO reportDTO,
			HttpServletRequest request,HttpServletResponse response) {
		logger.debug("Inside updateTicket of TicketManagementConroller Starts"+reportDTO.getStatusEdit());
		try {
			String parameter = request.getParameter("ticketId");
			String userName = request.getParameter("userIdValue");
			int ticketid = Integer.parseInt(parameter);
			reportDTO.setId(ticketid);

			if(!userName.equalsIgnoreCase(Constants.BLANK)&& userName!= null){
				User user = userService.getUserByUserName(userName);
				ticketDetailsService.updateTicketDetails(reportDTO,user);
				List<TicketDetailsMaster> ticketDetailsMasters = ticketDetailsService.getCountOfAssignedTickets(user.getUserId());
				reportDTO.setCountOfTickets(ticketDetailsMasters.size());
				reportDTO.setUserId(user);
				ticketUserMappingService.saveCountOfTickets(reportDTO);
				return "redirect:manageTicket.html";
			}else{
				logger.debug("ELSE");
				return "redirect:manageTicket.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param ticketID
	 * @param response
	 * @return
	 */
	@RequestMapping("/download/{ticketID}")
	public String download(@PathVariable("ticketID")
	Integer ticketID, HttpServletResponse response) {
		logger.debug("Inside download of TicketManagementConroller Ends");
		TicketDetailsMaster detailsMaster;
		try {
			detailsMaster = ticketDetailsService.get(ticketID);
			response.setHeader("Content-Disposition", "inline;filename=\"" +detailsMaster.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(detailsMaster.getContentType());
			InputStream myInputStream = new ByteArrayInputStream(detailsMaster.getContent()); 
			IOUtils.copy(myInputStream, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/remove/{ticketID}")
	public String remove(@PathVariable("ticketID")
	Integer ticketID) {
		logger.debug("Inside download of TicketManagementConroller Ends");
		try {
			ticketDetailsService.removeAttachedFile(ticketID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:manageTicket.html";
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/viewSummaryGrid.html")
	public ModelAndView viewSummaryGrid(HttpServletRequest request,HttpServletResponse response,Principal principal ) {
		logger.debug("Inside viewSummaryGrid of TicketManagementConroller Starts");
		ModelAndView modelAndView = null;
		try {
			String name = principal.getName();
			modelAndView=new ModelAndView(SUMMARY_GRID);

			List<TicketDetailsMaster> ticketDetailsMasters = ticketDetailsService.getAllTicketDetailsSummary();
			int countActive=0;
			int countResolved=0;
			int countSuspended=0;
			int countNotAssigned=0;
			for (TicketDetailsMaster ticketDetailsMaster : ticketDetailsMasters) {
				if(ticketDetailsMaster.getUserId()!= null){
					if(ticketDetailsMaster.getActive().equals(StatusEnum.Active)){
						countActive++;
					}
					else if(ticketDetailsMaster.getActive().equals(StatusEnum.Resolved)){
						countResolved++;
					}
					else if(ticketDetailsMaster.getActive().equals(StatusEnum.Suspended)){
						countSuspended++;
					}
				}
				else{
					countNotAssigned++;
					if(ticketDetailsMaster.getActive().equals(StatusEnum.Active)){
						countActive++;
					}
				}
				logger.debug("ticketDetailsMaster value::"+ticketDetailsMaster.getUserId());
			}
			modelAndView.addObject("ticketDetailsList", ticketDetailsMasters);
			modelAndView.addObject("author", name);
			modelAndView.addObject("countActive", countActive);
			modelAndView.addObject("countResolved", countResolved);
			modelAndView.addObject("countSuspended", countSuspended);
			modelAndView.addObject("countNotAssigned", countNotAssigned);
			logger.debug("IticketDetailsMasters"+ticketDetailsMasters.size());
			logger.debug("countActive:"+countActive);
			logger.debug("countPending:"+countResolved);
			logger.debug("countSuspended:"+countSuspended);
			logger.debug("countNotAssigned:"+countNotAssigned);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside viewSummaryGrid of TicketManagementConroller Ends");
		return modelAndView;
	}


	/**
	 * Handle request to download a PDF document
	 */
	@RequestMapping(value = "/downloadReport.html", method = RequestMethod.GET)
	public ModelAndView downloadReport() {
		logger.debug("Inside downloadReport of TicketManagementConroller Starts");
		List<TicketDetailsMaster> ticketDetailsMasters = null;
		try {
			ticketDetailsMasters = ticketDetailsService.getAllTicketDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside downloadReport of TicketManagementConroller Ends:"+ ticketDetailsMasters.size());
		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "ticketDetailsMasters", ticketDetailsMasters);
	}
}
