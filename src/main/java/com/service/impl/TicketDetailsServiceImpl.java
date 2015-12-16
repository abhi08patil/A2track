/**
 * 
 */
package com.service.impl;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.StringUtils;
import com.dao.TicketDao;
import com.dto.ReportDTO;
import com.model.TicketDetailsMaster;
import com.model.User;
import com.service.TicketDetailsService;

/**
 * @author ashish.gupta
 *
 */
@Service(TicketDetailsServiceImpl.SERVICE_NAME)
public class TicketDetailsServiceImpl implements TicketDetailsService {

	protected static Logger logger = Logger.getLogger("service");
	
	/**
	 * Service Name.
	 */
	public static final String SERVICE_NAME = "TicketDetailsService";

	@Autowired
	private TicketDao ticketDao;

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#saveTicketDetails(com.dto.ReportDTO)
	 */
	@Transactional
	public void saveTicketDetails(ReportDTO reportDTO)
			throws Exception {
		logger.debug("Inside saveTicketDetails of TicketDetailsServiceImpl Starts");
		TicketDetailsMaster ticketDetailsMaster=null;
		try {
			ticketDetailsMaster = new TicketDetailsMaster(reportDTO.getName(),reportDTO.getDescription(),
					reportDTO.getFile().getOriginalFilename(),reportDTO.getFile().getBytes(),reportDTO.getFile().getContentType(),reportDTO.getDate(),reportDTO.getPriority(),reportDTO.getStatus(),null,reportDTO.getEnvironment(),reportDTO.getActive(),
					reportDTO.getRequestedBy());
			ticketDao.saveTicketDetails(ticketDetailsMaster);
			logger.debug("Inside saveTicketDetails of TicketDetailsServiceImpl Ends");
		} catch (Exception exception) {					
			exception.printStackTrace();
			logger.debug("Exception occured :"+exception.getStackTrace());
		}
	}

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#getAllTicketDetails()
	 */
	public List<TicketDetailsMaster> getAllTicketDetails() throws Exception {
		logger.debug("Inside getAllTicketDetails of TicketDetailsServiceImpl Starts");
		List<TicketDetailsMaster> ticketDetailsMaster= ticketDao.getAllTicketDetails();
		return  ticketDetailsMaster;
	}

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#deleteTicket(java.lang.Integer)
	 */
	public void deleteTicket(Integer deleteId) throws Exception {
		logger.debug("Inside deleteTicket of TicketDetailsServiceImpl Starts");
		ticketDao.deleteTicket(deleteId);
		logger.debug("Inside deleteTicket of TicketDetailsServiceImpl Ends");
	}

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#updateTicketDetails(com.dto.ReportDTO)
	 */
	@Transactional
	public void updateTicketDetails(ReportDTO reportDTO,User user) throws Exception {
		logger.debug("Inside updateTicketDetails of TicketDetailsServiceImpl Starts:"+reportDTO.getStatusEdit());	
		TicketDetailsMaster ticketDetailsMaster = ticketDao.getDetailsById(reportDTO.getId());

		if (reportDTO.getDescription() != null
				&& !reportDTO.getDescription().isEmpty()) {
			String description= StringUtils.splitComma(reportDTO.getDescription());
			ticketDetailsMaster.setDescription(description);
		}
		if (reportDTO.getName() != null
				&& !reportDTO.getName().isEmpty()) {
			String name= StringUtils.splitComma(reportDTO.getName());
			ticketDetailsMaster.setName(name);
		}
		if (reportDTO.getPriority() != null
				&& !reportDTO.getPriority().isEmpty()) {
			String priority= StringUtils.splitComma(reportDTO.getPriority());
			ticketDetailsMaster.setPriority(priority);
		}
		if (reportDTO.getEnvironment() != null
				&& !reportDTO.getEnvironment().isEmpty()) {
			String environment= StringUtils.splitComma(reportDTO.getEnvironment());
			ticketDetailsMaster.setEnvironment(environment);
		}
		if (user != null) {
			//String doneBy= StringUtils.splitComma(reportDTO.getDoneBy());
			ticketDetailsMaster.setUserId(user);
		}
		ticketDetailsMaster.setCreated(reportDTO.getDate());
		if (reportDTO.getFile() != null
				&& !reportDTO.getFile().isEmpty()) {
			ticketDetailsMaster.setFilename(reportDTO.getFile().getOriginalFilename());
			ticketDetailsMaster.setContent(reportDTO.getFile().getBytes());
			ticketDetailsMaster.setContentType(reportDTO.getFile().getContentType());
		}

		if (reportDTO.getStatusEdit() != null) {
			//String description= StringUtils.splitComma(reportDTO.getDescription());
			ticketDetailsMaster.setActive(reportDTO.getStatusEdit());
		}
		
		ticketDao.updateTicketDetails(ticketDetailsMaster);

		logger.debug("Inside updateTicketDetails of TicketDetailsServiceImpl Ends");
	}

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#get(java.lang.Integer)
	 */
	@Transactional
	public TicketDetailsMaster get(Integer ticketID) throws Exception {
		logger.debug("Inside get of TicketDetailsServiceImpl Starts");	
		return ticketDao.getTicketId(ticketID);
	}

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#removeAttachedFile(java.lang.Integer)
	 */
	@Transactional
	public void removeAttachedFile(Integer ticketID) {
		logger.debug("Inside removeAttachedFile of TicketDetailsServiceImpl Starts");	
		try {
			ticketDao.removeAttachedFile(ticketID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside removeAttachedFile of TicketDetailsServiceImpl Starts");
	}

	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#getCountOfAssignedTickets(int)
	 */
	public List<TicketDetailsMaster> getCountOfAssignedTickets(int assignedTo)
			throws Exception {
		logger.debug("Inside getCountOfAssignedTickets of TicketDetailsServiceImpl Starts");
		//String assigned= StringUtils.splitComma(assignedTo);
		List<TicketDetailsMaster> ticketDetailsMaster= ticketDao.getCountOfAssignedTickets(assignedTo);
		return  ticketDetailsMaster;
	}
	
	/* (non-Javadoc)
	 * @see com.service.TicketDetailsService#getAllTicketDetailsSummary()
	 */
	public List<TicketDetailsMaster> getAllTicketDetailsSummary()
			throws Exception {
		logger.debug("Inside getAllTicketDetailsSummary of TicketDetailsServiceImpl Starts");
		List<TicketDetailsMaster> ticketDetailsMaster= ticketDao.getAllTicketDetailsSummary();
		return  ticketDetailsMaster;
	}
}
