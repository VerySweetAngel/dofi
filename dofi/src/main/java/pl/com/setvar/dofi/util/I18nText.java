package pl.com.setvar.dofi.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * klasa zasobów tekstów  - metoda get(klucz z pliku) zwraca zadaną treść
 * @author Marta
 */
public class I18nText {

    private ResourceBundle bundle;

    public I18nText(Bundles name) {
        String bundleName = name.getPath();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext.getViewRoot().getLocale();
        bundle = ResourceBundle.getBundle(bundleName, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}