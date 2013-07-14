package pl.com.setvar.dofi.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.com.setvar.dofi.dao.HibernateUtil;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.DefaultLogger;
import pl.com.setvar.dofi.util.I18nText;

/**
 * Klasa użytkownika aplikacji. Zarządzane ziarno ma zakres sesji i nazwę "user".
 * Użytkownik potrafi się zalogować i pamięta ostatni błąd logowania.
 * Klasa połączona z bazą danych.
 * @author tirpitz
 */
@ManagedBean
@SessionScoped
public class User implements Serializable {

    private int id = 0;
    private String login = "";
    private String password = "";
    private String realName = "";
    private String email = "";
    private boolean isAdmin = false;
    
    private boolean loggerdIn = false;
    private String lastLoginError = "";

    /** pusty konstruktor */
    public User() {
    }

    /** 
     * Metoda próbuje zalogowac użytkownika zgodnie z zadanym hasłem i loginem. W przypadku sukcesu zwróci wartośc parawda.
     * W przypadku błędu logowania, zwróci wartośc fałsz i zapamięta treść ostatniego błędu logowania w lastLoginError.
     */
    public boolean tryToLogMeIn(String login, String password) {
        DefaultLogger.DEFAULT.debug("User.tryToLogMeIn", ": login [", login, "] password [", password, "]");
        
        List<User> customers;
        customers = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User").list();
        for(User u : customers){
            DefaultLogger.DEFAULT.info(u.id, u.login, u.password);
        }
        
        if (login.equals("tester") && password.equals("tester")) {
            this.setLogin(login);
            this.setPassword(password);
            this.loggerdIn = true;
        } else {
            I18nText i18nText = new I18nText(Bundles.I18N_INDEX);
            lastLoginError = i18nText.get("badPassword");
            loggerdIn = false;
        }
        return this.isLoggerdIn();
    }

    /** wylogowanie użytkownika */
    public void logout() {
        login = "";
        password = "";
        loggerdIn = false;
        lastLoginError = "";
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
    
    /**
     * @return the lastLoginError
     */
    public String getLastLoginError() {
        return lastLoginError;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName the realName to set
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the loggerdIn
     */
    public boolean isLoggerdIn() {
        return loggerdIn;
    }
}
