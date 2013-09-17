package pl.com.setvar.dofi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.com.setvar.dofi.util.DefaultLogger;

/**
 * Klasa obslługuje bazę danych. Zwraca fabrykę sesji i aktualną sesję. Obiekt klasy służy do obsługi transakcji.
 *
 * @author tirpitz
 */
public class HibernateUtil {
    
    /** transakcja w ramach bazy danych */
    private Transaction transaction;
    
    /** metoda rozpoczyna transakcję w ramach bazy danych */
    public void beginTransaction(){
        transaction = getSessionFactory().getCurrentSession().beginTransaction();
        DefaultLogger.HIBERNATE.debug("HibernateUtil.beginTransaction transaction begun");
    }
    
    /** metoda zatwierdza transakcję w ramach bazy danych */
    public void commitTransaction(){
        transaction.commit();
        DefaultLogger.HIBERNATE.debug("HibernateUtil.commitTransaction transaction commited");
        System.out.println("HibernateUtil.commitTransaction transaction commited");
    }
    
    /** metoda cofa transakcję, jeżeli ta istnieje */
    public void rollbackTransaction(){
        if (transaction != null){
            transaction.rollback();
            DefaultLogger.HIBERNATE.debug("HibernateUtil.rollbackTransaction transaction rollback");
        } else {
            DefaultLogger.HIBERNATE.debug("HibernateUtil.rollbackTransaction no transaction to rollback");
        }
    }

    /** fabryka sesji */
    private static SessionFactory sessionFactory;

    /** funkcja zwrca fabryke sesji */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /** funkcja zwraca aktualną sesję */
    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    /** funkcja tworzy nową fabrykę sesji w ramach klasy */
    public static void createFactory() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            DefaultLogger.HIBERNATE.info("HibernateUtil.createFactory session factory created");
        } catch (Throwable ex) {
            DefaultLogger.HIBERNATE.fatal("HibernateUtil.createFactory cannot build session factory", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /** funckaj zamyka sesję */
    public static void closeFactory(){
        sessionFactory.close();       
        DefaultLogger.HIBERNATE.info("HibernateUtil.close session factory closed");
    }
}
