/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 * ziarenko strony ustawień
 * @author tirpitz
 */
@ManagedBean
@ViewScoped
public class Settings implements Serializable{
    
    private String newPassword = "";
    private String repeatedPassword = "";
    @ManagedProperty("sessionUser")
    private SessionUser sessionUser;
    
    public void saveUserSettings(){
        I18nText texts = new I18nText(Bundles.I18N_SETTINGS);
        FacesMessage msg;
        if(newPassword.equals(repeatedPassword)){
            if(newPassword.equals(sessionUser.getLoggedInUser().getPassword())){
                sessionUser.getLoggedInUser().setPassword(newPassword);
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", texts.get("userSettingsSaved"));
            } else{
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, texts.get("badPassword"), texts.get("userSettingsSaveError")); 
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, texts.get("badRepeatedPassword"), texts.get("userSettingsSaveError"));
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
