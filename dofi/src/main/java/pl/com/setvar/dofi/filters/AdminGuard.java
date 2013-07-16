/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.filters;

import pl.com.setvar.dofi.domain.SessionUser;
import pl.com.setvar.dofi.util.DefaultLogger;

/**
 *  Filtr sprawdza, czy user jest adminem.
 * @author tirpitz
 */
public class AdminGuard extends LoggedInGuard {

    @Override
    protected boolean canContinueChain(SessionUser sessionUser){
        boolean canContinueChain = false;
        if(sessionUser != null){
            canContinueChain = sessionUser.isAdmin();
        }
        DefaultLogger.DEFAULT.debug("AdminGuard canContinueChain = ", canContinueChain);
        return canContinueChain;
    }    
}
