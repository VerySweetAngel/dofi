package pl.com.setvar.dofi.util;

/**
 * Interfejs klasy narzędziowej do dodawania wiadomości do kontekstu.
 * @author tirpitz
 */
public interface MessageAdder {

    /**
     * Metoda dodaje wiadomość o błędzie do kontekstu.
     *
     * @param boundle paczka z tekstami
     * @param titleKey klucz tytułu wiadomości
     * @param textKey klucz treści wiadomości
     */
    void addErrorMessage(Bundles boundle, String textKey, String titleKey);
    
    /**
     * Metoda dodaje wiadomość o błędzie do kontekstu.
     *
     * @param boundle paczka z tekstami
     * @param textKey klucz treści wiadomości
     */
    void addErrorMessage(Bundles boundle, String textKey);

    /**
     * Metoda dodaje wiadomość informacyjną do kontekstu.
     *
     * @param boundle paczka z tekstami
     * @param textKey klucz tekstu
     */
    void addInfoMessage(Bundles boundle, String textKey);
}
