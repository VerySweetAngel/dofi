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
    public LoginController() {}
    
    /** próba zalogowania uzytkownika */
    public String logMeIn(){
        final FacesMessage msg;
        if(user.tryToLogMeIn(login, password)){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logowanie zakończyło się sukcesem", "");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd logowania", user.getLastLoginError());
        }
        FacesContext.getCurrentInstance().addMessage("loginMessage", msg);
        return null;
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
