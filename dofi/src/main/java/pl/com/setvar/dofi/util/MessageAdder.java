package pl.com.setvar.dofi.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Klasa narzędziowa do dodawania wiadomości do kontekstu.
 *
 * @author tirpitz
 */
public class MessageAdder {

    /**
     * Metoda dodaje wiadomość informacyjną do kontekstu.
     *
     * @param boundle paczka z tekstami
     * @param textKey klucz tekstu
     */
    public void addInfoMessage(Bundles boundle, String textKey) {
        addMessage(boundle, FacesMessage.SEVERITY_INFO, textKey, null);
    }

    /**
     * Metoda dodaje wiadomość o błędzie do kontekstu.
     *
     * @param boundle paczka z tekstami
     * @param titleKey klucz tytułu wiadomości
     * @param textKey klucz treści wiadomości
     */
    public void addErrorMessage(Bundles boundle, String textKey, String titleKey) {
        addMessage(boundle, FacesMessage.SEVERITY_ERROR, textKey, titleKey);
    }
    
    /**
     * Metoda dodaje wiadomość o błędzie do kontekstu.
     *
     * @param boundle paczka z tekstami
     * @param textKey klucz treści wiadomości
     */
    public void addErrorMessage(Bundles boundle, String textKey) {
        addMessage(boundle, FacesMessage.SEVERITY_ERROR, textKey, null);
    }

    /**
     * Metoda dodaje zadaną wiadomość do kontekstu.
     *
     * @param b paczka z tekstami
     * @param s rodzaj wiadomości
     * @param titleKey klucz tytułu wiadomości
     * @param textKey klucz treści wiadomości
     */
    private void addMessage(Bundles b, FacesMessage.Severity s, String textKey, String titleKey) {
        I18nText texts = new I18nText(b);
        String title = titleKey == null ? null : texts.get(titleKey);
        String text = textKey == null ? null : texts.get(textKey);
        FacesMessage msg = new FacesMessage(s, title, text);
        String target = null;
        FacesContext.getCurrentInstance().addMessage(target, msg);
    }
}
