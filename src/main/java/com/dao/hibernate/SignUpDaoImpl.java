/**
 * 
 */
package com.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dao.SignUpDao;
import com.model.User;



/**
 * @author ashish.gupta
 *
 */
@Repository(SignUpDaoImpl.REPOSITORY_NAME)
public class SignUpDaoImpl extends GenericHibernateDaoImpl<User, Long> implements SignUpDao {

	protected static Logger logger = Logger.getLogger("dao");
	
	protected SignUpDaoImpl() {
		super(User.class);
	}

	/**
	 * declaration Repository name
	 */
	public static final String REPOSITORY_NAME = "signUpDao";

	@Autowired
	private SessionFactory sessionFactory;



	public User getUserById(final int userId){
		logger.debug("Inside getUserById of SignUpDaoImpl");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			criteria.add(Restrictions.eq("userId",userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (User) criteria.list().get(0);		
	}

	public int saveUserDetails(User user) throws Exception {
		logger.debug("Inside saveUserDetails of SignUpDaoImpl Starts");
		saveOrUpdate(user);
		logger.debug("Inside saveUserDetails of SignUpDaoImpl Ends");
		return user.getUserId();

	}

	public boolean isUsernameAlreadyExists(String username) throws Exception {
		logger.debug("Inside isUsernameAlreadyExists of SignUpDaoImpl" +username);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			criteria.add(Restrictions.eq("userName",username));

			if(!criteria.list().isEmpty()){
				logger.debug("List is not empty");
				return true;	
			}
			else {
				return false;
			}
		} catch (Exception e) {
			logger.debug("Exception came:");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isEmailIdAlreadyExists(String email) throws Exception {
		logger.debug("Inside isUsernameAlreadyExists of SignUpDaoImpl" +email);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			criteria.add(Restrictions.eq("email",email));

			if(!criteria.list().isEmpty()){
				logger.debug("List is not empty");
				return true;	
			}
			else {
				return false;
			}
		} catch (Exception e) {
			logger.debug("Exception came:");
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUserByUserName(String name) {
		logger.debug("Inside getUserByUserName of SignUpDaoImpl" +name);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		try {
			criteria.add(Restrictions.eq("userName",name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (User) criteria.list().get(0);	
	}
}

