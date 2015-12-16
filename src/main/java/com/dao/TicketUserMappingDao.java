/**
 * 
 */
package com.dao;


import java.util.List;

import com.model.TicketUserMapping;

/**
 * @author ashish.gupta
 *
 */
public interface TicketUserMappingDao extends GenericHibernateDao<TicketUserMapping, Long>  {

	public void saveCountOfTickets(TicketUserMapping ticketUserMapping) throws Exception;

	//public List<TicketUserMapping> getUserAssignedTicketCount()throws Exception;

}
