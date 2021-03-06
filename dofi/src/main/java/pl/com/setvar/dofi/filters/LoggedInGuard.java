package pl.com.setvar.dofi.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.com.setvar.dofi.domain.SessionUser;
import pl.com.setvar.dofi.util.DofiLogger;

// TODO dopisac komentarze
// TODO dopisać testy

/**
 * Filtr sprawdza, czy user jest zalogowany.
 *
 * @author tirpitz
 */
public class LoggedInGuard implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        SessionUser sessionUser = (SessionUser) httpServletRequest.getSession().getAttribute("sessionUser");
        if (canContinueChain(sessionUser)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            // TODO dorobić swoją stronę wyjątku
        }
    }

    @Override
    public void destroy() {
    }

    protected boolean canContinueChain(SessionUser sessionUser) {
        boolean canContinueChain = false;
        if (sessionUser != null) {
            canContinueChain = sessionUser.isLoggerdIn();
        }
        DofiLogger.DEFAULT.debug("LoggedInGuard canContinueChain = ", canContinueChain);
        return true;
    }
}
