/**
 * 
 */
package com.dao;

import java.util.List;
import com.model.TicketDetailsMaster;

/**
 * @author ashish.gupta
 *
 */
public interface TicketDao extends GenericHibernateDao<TicketDetailsMaster, Long>  {

	public void saveTicketDetails(TicketDetailsMaster ticketDetailsMaster) throws Exception;

	public List<TicketDetailsMaster> getAllTicketDetails() throws Exception;

	public void deleteTicket(Integer deleteId)throws Exception ;

	public TicketDetailsMaster getDetailsById(Integer id)throws Exception;

	public void updateTicketDetails(TicketDetailsMaster ticketDetailsMaster)throws Exception;

	public TicketDetailsMaster getTicketId(Integer ticketID) throws Exception;

	public void removeAttachedFile(Integer ticketID) throws Exception;

	public List<TicketDetailsMaster> getCountOfAssignedTickets(int assignedTo) throws Exception;
	
	public List<TicketDetailsMaster> getAllTicketDetailsSummary() throws Exception;

}
