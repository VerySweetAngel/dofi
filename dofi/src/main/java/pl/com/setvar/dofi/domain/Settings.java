package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.Bundles;

// TODO dodać testy jednostkowe
// TODO dorobić sortowanie i filtrowanie
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
     * wewnętrzna lista kategorii do zapisania
     */
    private ArrayList<Category> categories;
    /**
     * wewnętrzna lista kategorii do usunięcia
     */
    private Set<Category> categoriesToDelete = new HashSet<Category>();
    /**
     * wewnętrzna lista tag'ów do zapisania
     */
    private ArrayList<Tag> tags;
    /**
     * wewnętrzna lista tag'ów do usunięcia
     */
    private Set<Tag> tagsToDelete = new HashSet<Tag>();

    /**
     * Metoda zapisuje ustawienia użytkownika.
     */
    public void saveUserSettings() {
        sessionUser.getLoggedInUser().save();
        messageAdder.addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
    }

    /**
     * Metoda zapisuje zmianę hasła użytkownika. Wymagane jest podanie starego hasła powtórzenie nowego dwa razy.
     */
    public void passwordSettings() {
        setRepeatedPassword("");
        if (getNewPassword().equals(getRepeatedPassword())) {
            if (getNewPassword().equals(sessionUser.getLoggedInUser().getPassword())) {
                sessionUser.getLoggedInUser().setPassword(getNewPassword());
                sessionUser.getLoggedInUser().save();
                setNewPassword("");
                messageAdder.addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
            } else {
                messageAdder.addErrorMessage(Bundles.I18N_SETTINGS, "userSettingsSaveError", "badPassword");
            }
        } else {
            messageAdder.addErrorMessage(Bundles.I18N_SETTINGS, "userSettingsSaveError", "badRepeatedPassword");
        }
    }

    /**
     * Metoda zwraca listę kategorii.
     *
     * @return lista wszystkich kategorii
     */
    public List<Category> categories() {
        categories = Category.listAll();
        return categories;
    }

    /**
     * Metoda zwraca listę tag'ów.
     *
     * @return lista wszystkich tag'ów
     */
    public List<Tag> tags() {
        tags = Tag.listAll();
        return tags;
    }

    /**
     * Metoda usuwa zadaną kategorię.
     *
     * @param categoryToDelete kategoria do usunięcia
     */
    public void deleteCategory(Category categoryToDelete) {
        categoriesToDelete.add(categoryToDelete);
        categories.remove(categoryToDelete);
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
     * Metoda dodaje nową kategorię.
     */
    public void addCategory() {
        Category newCategory = new Category();
        categories.add(0, newCategory);
    }

    /**
     * Metoda dodaje nowy tag.
     */
    public void addTag() {
        Tag tag = new Tag();
        tags.add(0, tag);
    }

    /**
     * Metoda zapisuje zmiany poczynione w kategoriach.
     */
    public void saveCategories() {
        for (Category category : categories) {
            category.save();
        }
        for (Category category : categoriesToDelete) {
            category.delete();
        }
        categoriesToDelete.clear();
        // TODO dodać wiadomość
    }

    /**
     * Metoda zapisuje zmiany poczynione w tag'ach.
     */
    public void saveTags() {
        for (Tag nonCategory : tags) {
            nonCategory.save();
        }
        for (Tag nonCategory : tagsToDelete) {
            nonCategory.delete();
        }
        tagsToDelete.clear();
        // TODO dodać wiadomość
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
}
