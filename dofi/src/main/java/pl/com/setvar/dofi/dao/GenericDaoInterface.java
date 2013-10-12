package pl.com.setvar.dofi.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interfejs opisujący podstawowe operacje DAO.
 * @author tirpitz
 */
public interface GenericDaoInterface {

    /** usunięcie obiektu */
    void delete(final Object o);

    /** zwraca listę wszytkioch */
    <T> List<T> findAll(Class<T> klass);

    <T> T get(Class<T> klass, Serializable id);

    <T> T load(Class<T> klass, Serializable id);

    /** update na koniec sesji */
    void merge(final Object o);

    /** insert na końcu sesji */
    void persist(final Object o);

    /** update lub insert na koniec sesji */
    void replicate(final Object o);

    /** natychmiastowy insert */
    Serializable save(final Object o);

    /** natychmiastowe update lub insert */
    void saveOrUpdate(final Object o);

    /** natychmiastowy update */
    void update(final Object o);
    
}
