package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 * użytkownik używający aplikację w ramach trwającej sesji
 * @author tirpitz
 */
@ManagedBean()
@SessionScoped
public final class SessionUser implements Serializable {
    
    private String login = "";
    private String password = "";
    private boolean loggerdIn = false;
    private boolean admin = false;
    private User loggedInUser;

    public SessionUser() {
    }
    
    /** akcja wywołana ze strony */
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
        password = "";
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
     * @param loggerdIn the loggerdIn to set
     */
    public void setLoggerdIn(boolean loggerdIn) {
        this.loggerdIn = loggerdIn;
    }
    
    /** @param loggedInUser zalogowany user lub null */
    public User getLoggedInUser(){
        return loggedInUser;
    }
}
