package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

// TODO udokumentować klasę.
// TODO napisać testy jednostkowe.

/**
 * Użytkownik używający aplikacji w ramach trwającej sesji.
 *
 * @author tirpitz
 */
@ManagedBean
@SessionScoped
public final class SessionUser implements Serializable {

    private String login = "";
    private String password = "";
    private boolean loggerdIn = false;
    private boolean admin = false;
    private User loggedInUser;

    /**
     * Konstruktor klasy.
     */
    public SessionUser() {
    }

    /**
     * Metoda realizuje akcję, wywoływaną ze strony logowania - próba zalogowania użytkownika według podanych danych.
     */
    public void logMeIn() {
        FacesMessage msg;
        I18nText texts = new I18nText(Bundles.I18N_INDEX);
        tryToLogUser();
        if (isLoggerdIn()) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", texts.get("loginWasSuccessful"));
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, texts.get("badPassword"), texts.get("loginError"));
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void tryToLogUser() {
        loggedInUser = new User(login, password);
        setLoggerdIn(loggedInUser.loadIfExistsByCredentials());
        admin = loggedInUser.isIsAdmin();
    }

    public String logMeOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        I18nText texts = new I18nText(Bundles.I18N_INDEX);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", texts.get("logout"));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/index";
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param userLogin the login to set
     */
    public void setLogin(String userLogin) {
        this.login = userLogin;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param userPassword the password to set
     */
    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @return the loggerdIn
     */
    public boolean isLoggerdIn() {
        return loggerdIn;
    }

    /**
     * Metoda ustawia flagę zalogowanego użytkownika.
     *
     * @param isUserLoggedIn czy uzytkownik jest zalogowany?
     */
    public void setLoggerdIn(boolean isUserLoggedIn) {
        this.loggerdIn = isUserLoggedIn;
    }

    /**
     * Metoda zwraca zalogowanego użytkownika.
     *
     * @return zalogowany użytkownik
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
