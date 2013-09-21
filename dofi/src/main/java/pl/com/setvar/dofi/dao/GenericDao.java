package pl.com.setvar.dofi.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;

/**
 * Bazowa klasa DAO.
 * @author tirpitz
 */
public class GenericDao implements GenericDaoInterface {

    protected Session getSession() {
        return HibernateUtil.getCurrentSession();
    }

    /** natychmiastowy insert */
    @Override
    public Serializable save(final Object o) {
        return getSession().save(o);
    }

    /** insert na końcu sesji */
    @Override
    public void persist(final Object o) {
        getSession().persist(o);
    }
    
    /** usunięcie obiektu */
    @Override
    public void delete(final Object o){
        getSession().delete(o);
    }
    
    /** natychmiastowy update */
    @Override
    public void update(final Object o) {
        getSession().update(o);
    }
    
    /** update na koniec sesji */
    @Override
    public void merge(final Object o) {
        getSession().merge(o);
    }
    
    /** natychmiastowe update lub insert */
    @Override
    public void saveOrUpdate(final Object o) {
        getSession().saveOrUpdate(o);
    }
    
    /** update lub insert na koniec sesji */
    @Override
    public void replicate(final Object o) {
        getSession().replicate(o, ReplicationMode.OVERWRITE);
    }
    
    @Override
    public <T> T get(Class<T> klass, Serializable id){
        return (T) getSession().get(klass, id);
    }
    
    @Override
    public <T> T load(Class<T> klass, Serializable id){
        return (T) getSession().load(klass, id);
    }
    
    /** zwraca listę wszytkioch */
    @Override
    public <T> List<T> findAll(Class<T> klass){
        return getSession().createQuery(String.format("FROM %s", klass.getSimpleName())).list();
    }
}
