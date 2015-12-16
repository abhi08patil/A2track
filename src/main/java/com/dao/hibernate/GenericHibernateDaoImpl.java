package com.dao.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dao.*;


/**
 *This class will be the base class for all DAOImpls
 */
@Repository("genericHibernateDao")
public abstract class GenericHibernateDaoImpl<E, I extends Serializable> extends GenericDAOImpl implements GenericHibernateDao<E,I> {

    private Class<E> entityClass;

   
    
    protected GenericHibernateDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }


	/**
	 * Autowired Session factory
	 */
	@Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    
    public void saveOrUpdate(E e) {
       getCurrentSession().saveOrUpdate(e);
    }

   
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
    

    public void merge(E e) {
        getCurrentSession().merge(e);
    }


}
