package com.dao;

import java.io.Serializable;

/**
 * Base dao for all dao interfaces 
 */
public interface GenericHibernateDao<E, I extends Serializable> {

    /**
     * Base method to get a record by id from DB.
     * @param id
     * @return Object
     */
    E findById(I id);
    
    /**
     * This method will save or update any entity
     * @param e
     */
    void saveOrUpdate(E e);
    
    /**
     * This method will hard delete a record
     * @param e
     */
    void delete(E e);
    
    
    /**
     * This method will merge a record
     * @param e
     */
    public void merge(E e);
    
}
