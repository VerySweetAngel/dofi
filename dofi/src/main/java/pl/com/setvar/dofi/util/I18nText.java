/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marta
 */
public class I18nText {

    
    
    private String bundleName;
    ResourceBundle bundle;

    public I18nText(Bundles name) {
        bundleName = name.getPath();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext.getViewRoot().getLocale();
        bundle = ResourceBundle.getBundle(bundleName, locale);
    }
    
    public String get(String key){
        return bundle.getString(key);
    }
}