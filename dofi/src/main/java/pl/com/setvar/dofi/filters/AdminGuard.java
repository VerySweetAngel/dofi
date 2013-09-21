package pl.com.setvar.dofi.filters;

import pl.com.setvar.dofi.domain.SessionUser;
import pl.com.setvar.dofi.util.DofiLogger;

// TODO dopisać test

/**
 *  Filtr sprawdza, czy user jest adminem.
 * @author tirpitz
 */
public class AdminGuard extends LoggedInGuard {

    // TODO dopisac komentarz
    
    @Override
    protected boolean canContinueChain(SessionUser sessionUser){
        boolean canContinueChain = false;
        if(sessionUser != null){
            canContinueChain = sessionUser.isAdmin();
        }
        DofiLogger.DEFAULT.debug("AdminGuard canContinueChain = ", canContinueChain);
        return canContinueChain;
    }    
}
