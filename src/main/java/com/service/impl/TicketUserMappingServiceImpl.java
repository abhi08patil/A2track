/**
 * 
 */
package com.service.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.TicketUserMappingDao;
import com.dto.ReportDTO;
import com.model.TicketUserMapping;
import com.service.TicketUserMappingService;

/**
 * @author ashish.gupta
 *
 */
@Service(TicketUserMappingServiceImpl.SERVICE_NAME)
public class TicketUserMappingServiceImpl implements TicketUserMappingService {

	protected static Logger logger = Logger.getLogger("service");
	/**
	 * Service Name.
	 */
	public static final String SERVICE_NAME = "TicketUserMappingService";
	
	@Autowired
	private TicketUserMappingDao ticketUserMappingDao;
	
	@Transactional
	public void saveCountOfTickets(ReportDTO reportDTO) throws Exception {
	
		logger.debug("Inside saveCountOfTickets of TicketUserMappingServiceImpl Starts");
		TicketUserMapping ticketUserMapping=null;
		try {
			ticketUserMapping = new TicketUserMapping(reportDTO.getUserId(),reportDTO.getCountOfTickets());
			ticketUserMappingDao.saveCountOfTickets(ticketUserMapping);
			logger.debug("Inside saveCountOfTickets of TicketUserMappingServiceImpl Ends");
		} catch (Exception exception) {					
			exception.printStackTrace();
			logger.debug("Exception occured :"+exception.getStackTrace());

		}
		
	}

	/*public List<TicketUserMapping> getUserAssignedTicketCount()
			throws Exception {
		logger.debug("Inside getUserAssignedTicketCount of TicketUserMappingServiceImpl Starts");
		return ticketUserMappingDao.getUserAssignedTicketCount();
	}*/

}
