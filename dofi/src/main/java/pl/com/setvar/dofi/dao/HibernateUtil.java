package pl.com.setvar.dofi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import pl.com.setvar.dofi.util.DofiLogger;

/**
 * Klasa obslługuje bazę danych. Zwraca fabrykę sesji i aktualną sesję. Obiekt klasy służy do obsługi transakcji.
 *
 * @author tirpitz
 */
public class HibernateUtil {

    /**
     * transakcja w ramach bazy danych
     */
    private Transaction transaction;

    /**
     * metoda rozpoczyna transakcję w ramach bazy danych
     */
    public void beginTransaction() {
        transaction = getSessionFactory().getCurrentSession().beginTransaction();
        DofiLogger.HIBERNATE.debug("HibernateUtil.beginTransaction transaction begun");
    }

    /**
     * metoda zatwierdza transakcję w ramach bazy danych
     */
    public void commitTransaction() {
        transaction.commit();
        DofiLogger.HIBERNATE.debug("HibernateUtil.commitTransaction transaction commited");
    }

    /**
     * metoda cofa transakcję, jeżeli ta istnieje
     */
    public void rollbackTransaction() {
        if (transaction != null) {
            transaction.rollback();
            DofiLogger.HIBERNATE.debug("HibernateUtil.rollbackTransaction transaction rollback");
        } else {
            DofiLogger.HIBERNATE.debug("HibernateUtil.rollbackTransaction no transaction to rollback");
        }
    }
    /**
     * fabryka sesji
     */
    private static SessionFactory sessionFactory;

    /**
     * funkcja zwrca fabryke sesji
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * funkcja zwraca aktualną sesję
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * funkcja tworzy nową fabrykę sesji w ramach klasy
     */
    public static void createFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            DofiLogger.HIBERNATE.info("HibernateUtil.createFactory session factory created");
        }
        catch (Throwable ex) {
            DofiLogger.HIBERNATE.fatal("HibernateUtil.createFactory cannot build session factory", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * funkcja zamyka sesję
     */
    public static void closeFactory() {
        sessionFactory.close();
        DofiLogger.HIBERNATE.info("HibernateUtil.close session factory closed");
    }
}
