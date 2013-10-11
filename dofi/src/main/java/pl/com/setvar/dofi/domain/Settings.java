package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 * Bean strony ustawień.
 *
 * @author tirpitz
 */
@ManagedBean
@ViewScoped
public class Settings extends BaseBackingBean implements Serializable {

    /**
     * stare hasło
     */
    private String oldPassword = "";
    /**
     * nowe hasło
     */
    private String newPassword = "";
    /**
     * powtórzenie nowego hasła
     */
    private String repeatedPassword = "";
    /**
     * zalogowany użytkownik
     */
    @ManagedProperty("#{sessionUser}")
    private SessionUser sessionUser;
    /**
     * wewnętrzna lista tag'ów do zapisania
     */
    protected ArrayList<Tag> tags = new ArrayList<Tag>();
    /**
     * wewnętrzna lista tag'ów do usunięcia
     */
    protected Set<Tag> tagsToDelete = new HashSet<Tag>();
    
    short tagnameSort = 0;
    short parentSort = 0;

    public String tagnameButton() {
        I18nText text = new I18nText(Bundles.I18N_SETTINGS);
        String buttonName = text.get("tagName"); 
        switch (tagnameSort) {
            case 1:
                return buttonName + " (A-Z)";
            case -1:
                return buttonName + " (Z-A)";
            default:
                return buttonName;
        }
    }
    
    public String parentButton() {
        I18nText text = new I18nText(Bundles.I18N_SETTINGS);
        String buttonName = text.get("parent"); 
        switch (parentSort) {
            case 1:
                return buttonName + " (A-Z)";
            case -1:
                return buttonName + " (Z-A)";
            default:
                return buttonName;
        }
    }
    
    public void sortByParent(){
        parentSort = parentSort == 0 ? 1 : parentSort;
        tagnameSort = 0;
        parentSort *= -1;
        if (parentSort == 0){
            return;
        }
        Comparator<Tag> comparator;
        if (parentSort == -1){
            comparator = new Comparator<Tag>() {
                @Override
                public int compare(Tag o1, Tag o2) {
                    Tag o1Par = o1.getParent();
                    Tag o2Par = o2.getParent();
                    String par1Name = (o1Par != null ? o1Par.getTagname() : "");
                    String par2Name = (o2Par != null ? o2Par.getTagname() : "");
                    return par1Name.compareToIgnoreCase(par2Name) * -1;
                }
            };
        } else {
            comparator = new Comparator<Tag>() {
                @Override
                public int compare(Tag o1, Tag o2) {
                    Tag o1Par = o1.getParent();
                    Tag o2Par = o2.getParent();
                    String par1Name = (o1Par != null ? o1Par.getTagname() : "");
                    String par2Name = (o2Par != null ? o2Par.getTagname() : "");
                    return par1Name.compareToIgnoreCase(par2Name);
                }
            };
        }
        java.util.Collections.sort(tags, comparator);
    }
    
    public void sortByTagname(){
        tagnameSort = tagnameSort == 0 ? 1 : tagnameSort;
        parentSort = 0;
        tagnameSort *= -1;
        if (tagnameSort == 0){
            return;
        }
        Comparator<Tag> comparator;
        if (tagnameSort == -1){
            comparator = new Comparator<Tag>() {
                @Override
                public int compare(Tag o1, Tag o2) {
                    return o1.getTagname().compareToIgnoreCase(o2.getTagname()) * -1;
                }
            };
        } else {
            comparator = new Comparator<Tag>() {
                @Override
                public int compare(Tag o1, Tag o2) {
                    return o1.getTagname().compareToIgnoreCase(o2.getTagname());
                }
            };
        }
        java.util.Collections.sort(tags, comparator);
    }

    /**
     * Metoda zapisuje ustawienia użytkownika.
     */
    public void saveUserSettings() {
        sessionUser.save();
        messageAdder.addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
    }

    /**
     * Metoda zapisuje zmianę hasła użytkownika. Wymagane jest podanie starego hasła powtórzenie nowego dwa razy.
     */
    public void savePasswordChange() {
        boolean passwordRepeatedCorectly = getNewPassword().equals(getRepeatedPassword());
        if (passwordRepeatedCorectly) {
            boolean oldPasswordCorrect = getOldPassword().equals(sessionUser.getPassword());
            if (oldPasswordCorrect) {
                sessionUser.setPassword(getNewPassword());
                sessionUser.save();
                messageAdder.addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
            } else {
                messageAdder.addErrorMessage(Bundles.I18N_SETTINGS, "userSettingsSaveError", "badPassword");
            }
        } else {
            messageAdder.addErrorMessage(Bundles.I18N_SETTINGS, "userSettingsSaveError", "badRepeatedPassword");
        }
        setNewPassword("");
        setRepeatedPassword("");
        setOldPassword("");
    }

    /**
     * Metoda zwraca listę tag'ów.
     *
     * @return lista wszystkich tag'ów
     */
    public List<Tag> tags() {
        if (tags.isEmpty()) {
            tags = Tag.listAll();
        }
        return tags;
    }

    /**
     * Metoda usuwa zadany tag.
     *
     * @param tagToDelete tag do usunięcia
     */
    public void deleteTag(Tag tagToDelete) {
        tagsToDelete.add(tagToDelete);
        tags.remove(tagToDelete);
    }

    /**
     * Metoda dodaje nowy tag.
     */
    public void addTag() {
        Tag tag = new Tag();
        tags.add(0, tag);
    }

    /**
     * Metoda dodaje nową kategorię.
     */
    public void addCategory() {
        Category category = new Category();
        tags.add(0, category);
    }

    /**
     * Metoda zapisuje zmiany poczynione w tag'ach. Wyświetla wiadomość o zapisaniu ustawień.
     */
    public void saveTags() {
        for (Tag tag : tags) {
            tag.save();
        }
        for (Tag tag : tagsToDelete) {
            tag.delete();
        }
        tagsToDelete.clear();
        messageAdder.addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
    }

    /**
     * @return nowe hasło
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword nowe hasło
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return powtórzone hasło hasło
     */
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    /**
     * @param repeatedPassword powtórzone hasło
     */
    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    /**
     * @param sessionUser zalogowany użytkownik
     */
    public void setSessionUser(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    /**
     * @param oldPassword stare hasło
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @return oldPassword stare hasło
     */
    public String getOldPassword() {
        return this.oldPassword;
    }
}
