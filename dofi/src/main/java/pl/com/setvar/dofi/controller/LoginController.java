/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 *
 * @author tirpitz
 */
@ManagedBean
@RequestScoped
public final class LoginController {

    @ManagedProperty(value = "#{user}")
    private User user;
    private String login;
    private String password;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    /**
     * próba zalogowania uzytkownika
     */
    public String logMeIn() {
        final FacesMessage msg;
        final I18nText i18nText = new I18nText(Bundles.I18N_INDEX);
        if (user.tryToLogMeIn(login, password)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", i18nText.get("loginWasSuccessful"));
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, user.getLastLoginError(), i18nText.get("loginError"));
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }

    public String logout() {
        user.logout();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        final I18nText i18nText = new I18nText(Bundles.I18N_INDEX);
        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", i18nText.get("logout"));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "index";
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
