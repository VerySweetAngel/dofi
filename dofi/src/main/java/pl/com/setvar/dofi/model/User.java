/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    
    public boolean tryToLogMeIn(String login, String password){
        
        if(login.equals("tester") && password.equals("tester")){
            this.login = login;
            this.password = password;
            this.loggerdIn = true;
        } else {
            lastLoginError = "Błędne hasło";
            loggerdIn = true;
        }
        return this.loggerdIn;
    }

    /**
     * @return the lastLoginError
     */
    public String getLastLoginError() {
        return lastLoginError;
    }
}
