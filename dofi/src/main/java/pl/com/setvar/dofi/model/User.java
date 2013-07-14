/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.DefaultLogger;
import pl.com.setvar.dofi.util.I18nText;

/**
 *
 * @author tirpitz
 */
@ManagedBean
@SessionScoped
public class User implements Serializable {

    private String login = "";
    private String password = "";
    private boolean loggerdIn = false;
    private String lastLoginError = "";

    /**
     * Creates a new instance of User
     */
    public User() {
    }

    public void logout() {

        login = "";
        password = "";
        loggerdIn = false;
        lastLoginError = "";
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    public boolean tryToLogMeIn(String login, String password) {
        DefaultLogger.debug("User.tryToLogMeIn", ": login [", login, "] password [", password, "]");
        if (login.equals("tester") && password.equals("tester")) {
            this.login = login;
            this.password = password;
            this.loggerdIn = true;
        } else {
            I18nText i18nText = new I18nText(Bundles.I18N_INDEX);
            lastLoginError = i18nText.get("badPassword");
            loggerdIn = false;
        }
        return this.isLoggerdIn();
    }

    /**
     * @return the lastLoginError
     */
    public String getLastLoginError() {
        return lastLoginError;
    }

    /**
     * @return the loggerdIn
     */
    public boolean isLoggerdIn() {
        return loggerdIn;
    }
}
