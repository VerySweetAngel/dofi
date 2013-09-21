package pl.com.setvar.dofi.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * Klasa zasobów tekstów. Metoda get(klucz z pliku) zwraca zadaną treść.
 * @author Marta
 */
public class I18nText {

    /** obiekt zasobu z tekstem */
    private ResourceBundle bundle;

    /**
     * Konstruktor do tworzenia nowego obiektu klasy.
     * @param name enum {@link pl.com.setvar.dofi.util.Bundles} wyznaczający zasób tekstowy
     */
    public I18nText(final Bundles name) {
        String bundleName = name.getPath();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext.getViewRoot().getLocale();
        bundle = ResourceBundle.getBundle(bundleName, locale);
    }

    /**
     * Metoda zwraca treść na podstawie klucza.
     * @param key klucz do wyszukania wartości
     * @return treść wyszukana na podstawie klucza
     */
    public String get(final String key) {
        return bundle.getString(key);
    }
}
