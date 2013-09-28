package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

// TODO dodać testy jednostkowe
// TODO udokumentować klasę

/**
 * Bean strony ustawień.
 * @author tirpitz
 */
@ManagedBean
@ViewScoped
public class Settings implements Serializable{
    
    /** nowe hasło */
    private String newPassword = "";
    /** powtórzenie nowego hasła */
    private String repeatedPassword = "";
    /** zalogowany użytkownik */
    @ManagedProperty("#{sessionUser}")
    private SessionUser sessionUser;
    
    /** wewnętrzna lista categorii do zapisania */
    private ArrayList<Category> categories;
    /** wewnętrzna lista categorii do usunięcia */
    private Set<Category> categoriesToDelete = new HashSet<Category>();
    
    /** wewnętrzna lista tagów do zapisania */
    private ArrayList<Tag> tags;
    /** wewnętrzna lista tagów do usunięcia */
    private Set<Tag> tagsToDelete = new HashSet<Tag>();
    
    // TODO dorobić sortowanie i filtrowanie
    
    /** metoda zapisuje ustawienia użytkownika */
    public void saveUserSettings(){
        setRepeatedPassword("");
        I18nText texts = new I18nText(Bundles.I18N_SETTINGS);
        FacesMessage msg;
        if(getNewPassword().equals(getRepeatedPassword())){
            if(getNewPassword().equals(sessionUser.getLoggedInUser().getPassword())){
                sessionUser.getLoggedInUser().setPassword(getNewPassword());
                setNewPassword("");
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", texts.get("userSettingsSaved"));
            } else{
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, texts.get("badPassword"), texts.get("userSettingsSaveError")); 
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, texts.get("badRepeatedPassword"), texts.get("userSettingsSaveError"));
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /** metoda zwraca lliste tagów, będących kategoriami */
    public List<Category> categories(){
        categories = Category.listAll();
        return categories;
    }
    
    /** metoda zwraca lliste tagów, będących kategoriami */
    public List<Tag> tags(){
        tags = Tag.listAll();
        return tags;
    }
    
    /** metoda usówa zadaną kategorię */
    public void deleteCategory(Category categoryToDelete){
        categoriesToDelete.add(categoryToDelete);
        categories.remove(categoryToDelete);
    }
    
    /** metoda usówa zadany tag nie będący kategorią */
    public void deleteTag(Tag tagToDelete){
        tagsToDelete.add(tagToDelete);
        tags.remove(tagToDelete);
    }
    
    /** metoda dodaje nową kategorię */
    public void addCategory(){
        Category newCategory = new Category();
        categories.add(0, newCategory);
    }
    
    /** metoda dodaje now tag nie będący kategorią */
    public void addNonCategory(){
        Tag tag = new Tag();
        tags.add(0, tag);
    }
    
    /** metoda zapisuje zmiany poczynione w kategoriach */
    public void saveCategories(){
        for(Category category : categories){
            category.save();
        }
        for(Category category : categoriesToDelete){
            category.delete();
        }
        categoriesToDelete.clear();
        // TODO dodać wiadomość
    }
    
     /** metoda zapisuje zmiany poczynione w tagach nie będących kategoriami */
    public void saveNonCategories(){
        for(Tag nonCategory : tags){
            nonCategory.save();
        }
        for(Tag nonCategory : tagsToDelete){
            nonCategory.delete();
        }
        tagsToDelete.clear();
        // TODO dodać wiadomość
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the repeatedPassword
     */
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    /**
     * @param repeatedPassword the repeatedPassword to set
     */
    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    /**
     * @param sessionUser the sessionUser to set
     */
    public void setSessionUser(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }
}
