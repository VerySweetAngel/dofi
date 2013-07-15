package pl.com.setvar.dofi.dao;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.com.setvar.dofi.util.DefaultLogger;

/**
 * Klasa obslługuje bazę danych. Zwraca fabryki sesji. Przed każdym żądaniem
 * HTTP i po nim, otwiera i kończy sesję. Tworzy fabrykę sesji przy starcie
 * aplikacji i zamyka ja na koniec.
 *
 * @author tirpitz
 */
public class HibernateUtil implements Filter {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        createFactory();
    }

    private void createFactory() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            DefaultLogger.HIBERNATE.info("HibernateUtil.createFactory session factory created");
        } catch (Throwable ex) {
            DefaultLogger.HIBERNATE.fatal("HibernateUtil.createFactory cannot build session factory", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        DefaultLogger.HIBERNATE.debug("HibernateUtil.doFilter filtering request");
        Transaction transaction = null;
        try {
            transaction = sessionFactory.getCurrentSession().beginTransaction();
            DefaultLogger.HIBERNATE.debug("HibernateUtil.doFilter transaction begun");
            chain.doFilter(request, response);
            transaction.commit();
            DefaultLogger.HIBERNATE.debug("HibernateUtil.doFilter transaction commited");
        } catch (Throwable ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            DefaultLogger.HIBERNATE.error("HibernateUtil.doFilter session error", ex);
        }
    }

    @Override
    public void destroy() {
        sessionFactory.close();
        DefaultLogger.HIBERNATE.info("HibernateUtil.destroy session factory closed");
    }
}
