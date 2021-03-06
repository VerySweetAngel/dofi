/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import pl.com.setvar.dofi.dao.HibernateUtil;
import pl.com.setvar.dofi.util.DofiLogger;

/**
 * Przed każdym żądaniem HTTP i po nim, otwiera i kończy sesję. Tworzy fabrykę sesji przy starcie
 * aplikacji i zamyka ją na koniec.
 * @author tirpitz
 */
public class HibernateSessionManager implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        HibernateUtil.createFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        DofiLogger.HIBERNATE.debug("HibernateUtil.doFilter filtering request");
        HibernateUtil hibernateUtil = new HibernateUtil();
        try {
            hibernateUtil.beginTransaction();
            chain.doFilter(request, response);
            hibernateUtil.commitTransaction();
        } catch (Throwable ex) {
            DofiLogger.HIBERNATE.error("HibernateUtil.doFilter session error", ex);
            hibernateUtil.rollbackTransaction();
        }
        DofiLogger.HIBERNATE.debug("HibernateUtil.doFilter request filtered");
    }

    @Override
    public void destroy() {
        HibernateUtil.closeFactory();
    }
    
}
