/**
 * 
 */
package com.dao.hibernate;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dao.TicketDao;
import com.enums.StatusEnum;
import com.model.TicketDetailsMaster;

/**
 * @author ashish.gupta
 *
 */
@Repository(TicketDaoImpl.REPOSITORY_NAME)
public class TicketDaoImpl extends GenericHibernateDaoImpl<TicketDetailsMaster, Long> implements TicketDao {

	protected static Logger logger = Logger.getLogger("dao");
	/**
	 * declaration Repository name
	 */
	public static final String REPOSITORY_NAME = "TicketDao";

	@Autowired
	private SessionFactory sessionFactory;

	protected TicketDaoImpl() {
		super(TicketDetailsMaster.class);
	}


	/* (non-Javadoc)
	 * @see com.dao.TicketDao#saveTicketDetails(com.model.TicketDetailsMaster)
	 */
	public void saveTicketDetails(TicketDetailsMaster ticketDetailsMaster) {
		logger.debug("Inside saveTicketDetails of TicketDaoImpl Starts");
		saveOrUpdate(ticketDetailsMaster);
		logger.debug("Inside saveTicketDetails of TicketDaoImpl Ends");
	}

	/* (non-Javadoc)
	 * @see com.dao.TicketDao#getAllTicketDetails()
	 */
	@SuppressWarnings("unchecked")
	public List<TicketDetailsMaster> getAllTicketDetails() throws Exception {
		logger.debug("Inside getAllTicketDetails of TicketDaoImpl Starts");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TicketDetailsMaster.class);
		criteria.add(Restrictions.eq("active", StatusEnum.Active));
		return(List<TicketDetailsMaster>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.dao.TicketDao#deleteTicket(java.lang.Integer)
	 */
	public void deleteTicket(Integer deleteId) throws Exception {
		logger.debug("Inside deleteTicket of TicketDaoImpl Starts");
		Session session = sessionFactory.openSession();
		String hql = "UPDATE TicketDetailsMaster set ACTIVE = 0 "  + 
				"WHERE id = "+deleteId;
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		logger.debug("Rows affected: " + result);
		logger.debug("Inside deleteTicket of TicketDaoImpl Ends");
	}

	/* (non-Javadoc)
	 * @see com.dao.TicketDao#getDetailsById(java.lang.Integer)
	 */
	public TicketDetailsMaster getDetailsById(Integer id) throws Exception {
		logger.debug("Inside getDetailsById of TicketDaoImpl" +id);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TicketDetailsMaster.class);
		try {
			criteria.add(Restrictions.eq("id",id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (TicketDetailsMaster) criteria.list().get(0);		
	}

	/* (non-Javadoc)
	 * @see com.dao.TicketDao#updateTicketDetails(com.model.TicketDetailsMaster)
	 */
	public void updateTicketDetails(TicketDetailsMaster ticketDetailsMaster)
			throws Exception {
		logger.debug("Inside updateTicketDetails of TicketDaoImpl Starts");
		saveOrUpdate(ticketDetailsMaster);
		logger.debug("Inside updateTicketDetails of TicketDaoImpl Ends");

	}

	/* (non-Javadoc)
	 * @see com.dao.TicketDao#getTicketId(java.lang.Integer)
	 */
	public TicketDetailsMaster getTicketId(Integer ticketID) throws Exception {
		logger.debug("Inside getTicketId of TicketDaoImpl" +ticketID);
		Session session = sessionFactory.getCurrentSession();
		return (TicketDetailsMaster)session.get(TicketDetailsMaster.class, ticketID);
	}

	public void removeAttachedFile(Integer ticketID) throws Exception {
		logger.debug("Inside getTicketId of TicketDaoImpl" +ticketID);
		Session session = sessionFactory.getCurrentSession();
		TicketDetailsMaster detailsMaster = (TicketDetailsMaster)session.get(TicketDetailsMaster.class, ticketID);
		session.delete(detailsMaster);

	}

	@SuppressWarnings("unchecked")
	public List<TicketDetailsMaster> getCountOfAssignedTickets(int assignedTo)
			throws Exception {
		logger.debug("Inside getCountOfAssignedTickets of TicketDaoImpl Starts"+assignedTo);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TicketDetailsMaster.class);
		criteria.add(Restrictions.eq("userId.userId", assignedTo));

		return(List<TicketDetailsMaster>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TicketDetailsMaster> getAllTicketDetailsSummary()
			throws Exception {
		logger.debug("Inside getAllTicketDetailsSummary of TicketDaoImpl Starts");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TicketDetailsMaster.class);
		//criteria.add(Restrictions.eq("active", StatusEnum.Active));
		return(List<TicketDetailsMaster>) criteria.list();
	}

}
