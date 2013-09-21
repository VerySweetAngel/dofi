package pl.com.setvar.dofi.util;

/**
 * Enum do plików z zasobami. Enymy przechowują ścieżki do zasobów.
 *
 * @author Marta
 */
public enum Bundles {

    /**
     * Teksty dla strony index.
     */
    I18N_INDEX("I18N/index"),
    /**
     * etksty dla strony settings.
     */
    I18N_SETTINGS("I18N/settings"),
    /**
     * etksty dla strony operations.
     */
    I18N_OPERATIONS("I18N/operations");
    
    /**
     * Ścieżka do pliku.
     */
    private String path;

    Bundles(String boundlePath) {
        this.path = boundlePath;
    }

    /**
     * Metoda zwraca ścieżkę do zasobu, który reprezentuje.
     * @return 
     */
    public String getPath() {
        return path;
    }
}
