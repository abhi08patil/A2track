/**
 * 
 */
package com.service;

import java.util.List;
import com.dto.ReportDTO;
import com.model.TicketDetailsMaster;
import com.model.User;

/**
 * @author ashish.gupta
 *
 */
public interface TicketDetailsService {

	public void saveTicketDetails(ReportDTO reportDTO) throws Exception;

	public List<TicketDetailsMaster> getAllTicketDetails() throws Exception;

	public void deleteTicket(Integer deleteId) throws Exception;

	public void updateTicketDetails(ReportDTO reportDTO, User user)throws Exception;

	public TicketDetailsMaster get(Integer ticketID)throws Exception;

	public void removeAttachedFile(Integer ticketID) throws Exception;

	public List<TicketDetailsMaster> getCountOfAssignedTickets(int userId) throws Exception;
	
	public List<TicketDetailsMaster> getAllTicketDetailsSummary() throws Exception;



}
