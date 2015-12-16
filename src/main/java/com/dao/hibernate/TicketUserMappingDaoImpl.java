/**
 * 
 */
package com.dao.hibernate;



import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dao.TicketUserMappingDao;
import com.model.TicketUserMapping;

/**
 * @author ashish.gupta
 *
 */
@Repository(TicketUserMappingDaoImpl.REPOSITORY_NAME)
public class TicketUserMappingDaoImpl extends GenericHibernateDaoImpl<TicketUserMapping, Long> implements TicketUserMappingDao {

	protected static Logger logger = Logger.getLogger("dao");
	/**
	 * declaration Repository name
	 */
	public static final String REPOSITORY_NAME = "TicketUserMappingDao";

	@Autowired
	private SessionFactory sessionFactory;

	protected TicketUserMappingDaoImpl() {
		super(TicketUserMapping.class);
	}

	public void saveCountOfTickets(TicketUserMapping ticketUserMapping)
			throws Exception {
		logger.debug("Inside saveCountOfTickets of TicketUserMappingDaoImpl Starts");
		saveOrUpdate(ticketUserMapping);
		logger.debug("Inside saveCountOfTickets of TicketUserMappingDaoImpl Ends");
		
	}

	public List<TicketUserMapping> getUserAssignedTicketCount()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
