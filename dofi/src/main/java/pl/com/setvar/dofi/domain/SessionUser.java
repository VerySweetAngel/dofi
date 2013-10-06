package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.Bundles;

// TODO udokumentować klasę.
// TODO napisać testy jednostkowe.
// TODO wyłączyć stąd funkcjonalności index.xhtml

/**
 * Użytkownik używający aplikacji w ramach trwającej sesji.
 *
 * @author tirpitz
 */
@ManagedBean
@SessionScoped
public class SessionUser extends BaseBackingBean implements Serializable {

    private boolean loggerdIn = false;
    private boolean admin = false;
    private User loggedInUser;
    
    
    private String enteredLogin = "";
    private String enteredPassword = "";

    /**
     * Konstruktor klasy.
     */
    public SessionUser() {
    }

    /**
     * Metoda realizuje akcję, wywoływaną ze strony logowania - próba zalogowania użytkownika według podanych danych.
     */
    public void logMeIn() {
        tryToLogUser();
        if (isLoggerdIn()) {
            messageAdder.addInfoMessage(Bundles.I18N_INDEX, "loginWasSuccessful");
        } else {
            messageAdder.addErrorMessage(Bundles.I18N_INDEX, "loginError", "badPassword");
        }
    }

    private void tryToLogUser() {
        loggedInUser = new User(enteredLogin, enteredPassword);
        setLoggerdIn(loggedInUser.loadIfExistsByCredentials());
        admin = loggedInUser.isIsAdmin();
    }

    public String logMeOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        messageAdder.addInfoMessage(Bundles.I18N_INDEX, "logout");
        return "/index";
    }

    /**
     * @return the login
     */
    public String getEnteredLogin() {
        return enteredLogin;
    }

    /**
     * @param userLogin the login to set
     */
    public void setEnteredLogin(String userLogin) {
        this.enteredLogin = userLogin;
    }

    /**
     * @return the password
     */
    public String getEnteredPassword() {
        return enteredPassword;
    }

    /**
     * @param userPassword the password to set
     */
    public void setEnteredPassword(String userPassword) {
        this.enteredPassword = userPassword;
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

    // TODO usunąć tą metodę - SessionUser powinna powielac interface User
    /**
     * Metoda zwraca zalogowanego użytkownika.
     *
     * @return zalogowany użytkownik
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }
    
    public String getPassword() {
        return loggedInUser.getPassword();
    }
    
    public void setPassword(String newPassword) {
        loggedInUser.setPassword(newPassword);
    }
    
        public void save() {
        loggedInUser.save();
    }
}
