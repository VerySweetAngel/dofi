/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.dao;

import java.io.Serializable;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;

/**
 *
 * @author tirpitz
 */
public class GenericDao {

    protected Session getSession() {
        return HibernateUtil.getCurrentSession();
    }

    /** natychmiastowy insert */
    public Serializable save(final Object o) {
        return getSession().save(o);
    }

    /** insert na końcu sesji */
    public void persist(final Object o) {
        getSession().persist(o);
    }
    
    /** natychmiastowy update */
    public void update(final Object o) {
        getSession().update(o);
    }
    
    /** update na koniec sesji */
    public void merge(final Object o) {
        getSession().merge(o);
    }
    
    /** natychmiastowe update lub insert */
    public void saveOrUpdate(final Object o) {
        getSession().saveOrUpdate(o);
    }
    
    /** update lub insert na koniec sesji */
    public void replicate(final Object o) {
        getSession().replicate(o, ReplicationMode.OVERWRITE);
    }
    
    public <T> T get(Class<T> klass, Serializable id){
        return (T) getSession().get(klass, id);
    }
    
    public <T> T load(Class<T> klass, Serializable id){
        return (T) getSession().load(klass, id);
    }
}
