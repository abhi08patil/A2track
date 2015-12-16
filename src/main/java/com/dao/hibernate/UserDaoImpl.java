/**
 * 
 */
package com.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.enums.StatusEnum;
import com.model.User;

/**
 * @author ashish.gupta
 *
 */

@Repository(UserDaoImpl.REPOSITORY_NAME)
public class UserDaoImpl extends GenericHibernateDaoImpl<User, Long> implements UserDao {

	protected static Logger logger = Logger.getLogger("dao");
	/**
	 * declaration Repository name
	 */
	public static final String REPOSITORY_NAME = "userDao";

	protected UserDaoImpl() {
		super(User.class);
	}

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.dao.UserDao#searchUserDetails(java.lang.String)
	 */
	public User searchUserDetails(final String name) throws Exception {
		logger.debug("Inside searchUserDetails of UserDaoImpl Starts"+name);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			if(name!=null){
				criteria.add(Restrictions.eq("userName",name));
			}
			criteria.add(Restrictions.eq("status", StatusEnum.Active));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside searchUserDetails of UserDaoImpl Ends");
		return (User) criteria.list().get(0);
	}

	/* (non-Javadoc)
	 * @see com.dao.UserDao#getListOfUsers()
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListOfUsers() throws Exception {
		logger.debug("Inside getListOfUsers of UserDaoImpl Starts");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("status", StatusEnum.Active));
		logger.debug("Inside getListOfUsers of UserDaoImpl Starts");
		return(List<User>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.dao.UserDao#getUserByUserName(java.lang.String)
	 */
	public User getUserByUserName(final String assigned) throws Exception {
		logger.debug("Inside getUserByUserName of UserDaoImpl Starts"+assigned);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			if(assigned!=null){
				criteria.add(Restrictions.eq("userName",assigned));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside getUserByUserName of UserDaoImpl Ends");
		return (User) criteria.list().get(0);
	}

	/* (non-Javadoc)
	 * @see com.dao.UserDao#getUserDetails(java.lang.String)
	 */
	public User getUserDetails(final String nameFinal) {
		logger.debug("Inside getUserDetails of UserDaoImpl Starts"+nameFinal);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			if(nameFinal!=null){
				criteria.add(Restrictions.eq("userName",nameFinal));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Inside getUserDetails of UserDaoImpl Ends");
		return (User) criteria.list().get(0);
	}

	public boolean updateUserDetails(User user) {
		logger.debug("Inside saveUserDetails of SignUpDaoImpl Starts");
		try {
			saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.debug("Inside saveUserDetails of SignUpDaoImpl Ends");
		return true;		
	}
}
