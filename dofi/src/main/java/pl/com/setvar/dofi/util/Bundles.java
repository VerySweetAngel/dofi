package pl.com.setvar.dofi.util;

/**
 * Enum do plików z zasobami.
 *
 * @author Marta
 */
public enum Bundles {

    /**
     * teksty dla strony index
     */
    I18N_INDEX("I18N/index"),
    /**
     * teksty dla strony settings
     */
    I18N_SETTINGS("I18N/settings"),
    /**
     * teksty dla strony operations
     */
    I18N_OPERATIONS("I18N/operations");
    /**
     * ścieżka do pliku
     */
    private String path;

    Bundles(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
