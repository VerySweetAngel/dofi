package pl.com.setvar.dofi.util;

/**
 * Enum do plików z zasobami. Enum'y przechowują ścieżki do zasobów.
 *
 * @author Marta
 */
public enum Bundles {

    /**
     * Teksty globalne - mogą być wszędzie.
     */
    I18N_GLOBAL("I18N/global"),
    /**
     * Teksty dla strony index.
     */
    I18N_INDEX("I18N/index"),
    /**
     * Teksty dla strony settings.
     */
    I18N_SETTINGS("I18N/settings"),
    /**
     * Teksty dla strony operations.
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
