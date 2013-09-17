package pl.com.setvar.dofi.util;

/**
 * enum do plików z zasobami 
 * @author Marta
 */
public enum Bundles {

    /** teksty dla strony index */
    I18N_INDEX("I18N/index"), I18N_OPERATIONS("I18N/operations");
    
    /** ścieżka do pliku */
    private String path;

    Bundles(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}