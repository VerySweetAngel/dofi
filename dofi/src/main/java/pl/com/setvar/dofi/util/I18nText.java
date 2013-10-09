package pl.com.setvar.dofi.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * Klasa zasobów tekstów. Metoda get(klucz z pliku) zwraca zadaną treść.
 *
 * @author Marta
 */
public class I18nText {

    /**
     * obiekt zasobu z tekstem
     */
    private ResourceBundle bundle;

    /**
     * Konstruktor do tworzenia nowego obiektu klasy.
     *
     * @param name enum {@link pl.com.setvar.dofi.util.Bundles} wyznaczający zasób tekstowy
     * @throws IllegalStateException jeżeli nie uda się utworzyć ResourceBundle
     */
    public I18nText(final Bundles name) {
        String bundleName = name.getPath();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Locale locale;
        if (facesContext == null) {
            locale = Locale.getDefault();
        } else {
            locale = facesContext.getViewRoot().getLocale();
        }
        bundle = ResourceBundle.getBundle(bundleName, locale);
        if (bundle == null){
            throw new IllegalStateException("null ResourceBundle");
        }
    }

    /**
     * Metoda zwraca treść na podstawie klucza.
     *
     * @param key klucz do wyszukania wartości
     * @return treść wyszukana na podstawie klucza
     * @throws IllegalArgumentException jeżeli nie ma tekstu dla zadanego klucza
     */
    public String get(final String key) {
        if (bundle.containsKey(key)== false){
            throw new IllegalArgumentException(String.format("ResourceBundle %s does not contain '%s'", bundle, key));
        }
        return bundle.getString(key);
    }
}
