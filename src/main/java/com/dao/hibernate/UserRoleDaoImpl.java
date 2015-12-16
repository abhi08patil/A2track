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
import com.dao.UserRoleDao;
import com.model.UserRole;

/**
 * @author ashish.gupta
 *
 */
@Repository(UserRoleDaoImpl.REPOSITORY_NAME)
public class UserRoleDaoImpl extends GenericHibernateDaoImpl<UserRole, Long> implements UserRoleDao {

	protected static Logger logger = Logger.getLogger("dao");

	@Autowired
	private SessionFactory sessionFactory;

	protected UserRoleDaoImpl() {
		super(UserRole.class);
	}

	/**
	 * declaration Repository name
	 */
	public static final String REPOSITORY_NAME = "userRoleDao";


	public void saveUserRoleDetails(UserRole userRole) throws Exception {
		logger.debug("Inside saveUserRoleDetails of SignUpDaohibernate");
		saveOrUpdate(userRole);
	}


	public UserRole getUserRoleMasterById(Integer id) throws Exception {
		logger.debug("Inside getUserRoleMasterById of UserRoleDaoImpl:" +id);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserRole.class);
		try {
			criteria.add(Restrictions.eq("user.userId",id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (UserRole) criteria.list().get(0);
	}
}

