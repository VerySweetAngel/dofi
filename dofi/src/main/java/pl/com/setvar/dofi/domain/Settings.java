/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

// TODO dodać testy jednostkowe

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
    @ManagedProperty("sessionUser")
    private SessionUser sessionUser;
    
    /** wewnętrzna lista categorii do zapisania */
    private ArrayList<Tag> categories;
    /** wewnętrzna lista categorii do usunięcia */
    private Set<Tag> categoriesToDelete = new HashSet<Tag>();
    
    /** wewnętrzna lista tagów do zapisania */
    private ArrayList<Tag> nonCategories;
    /** wewnętrzna lista tagów do usunięcia */
    private Set<Tag> nonCategoriesToDelete = new HashSet<Tag>();
    
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
    public List<Tag> categories(){
        categories = Tag.listAllCategories();
        return categories;
    }
    
    /** metoda zwraca lliste tagów, będących kategoriami */
    public List<Tag> nonCategories(){
        nonCategories = Tag.listAllTags();
        return nonCategories;
    }
    
    /** metoda usówa zadaną kategorię */
    public void deleteCategory(Tag categoryToDelete){
        categoriesToDelete.add(categoryToDelete);
        categories.remove(categoryToDelete);
    }
    
    /** metoda usówa zadany tag nie będący kategorią */
    public void deleteNonCategory(Tag nonCategoryToDelete){
        nonCategoriesToDelete.add(nonCategoryToDelete);
        nonCategories.remove(nonCategoryToDelete);
    }
    
    /** metoda dodaje nową kategorię */
    public void addCategory(){
        Tag newCategory = new Tag();
        newCategory.setCategory(true);
        categories.add(0, newCategory);
    }
    
    /** metoda dodaje now tag nie będący kategorią */
    public void addNonCategory(){
        Tag newNonCategory = new Tag();
        nonCategories.add(0, newNonCategory);
    }
    
    /** metoda zapisuje zmiany poczynione w kategoriach */
    public void saveCategories(){
        for(Tag category : categories){
            category.save();
        }
        for(Tag category : categoriesToDelete){
            category.delete();
        }
        categoriesToDelete.clear();
        // TODO dodać wiadomość
    }
    
     /** metoda zapisuje zmiany poczynione w tagach nie będących kategoriami */
    public void saveNonCategories(){
        for(Tag nonCategory : nonCategories){
            nonCategory.save();
        }
        for(Tag nonCategory : nonCategoriesToDelete){
            nonCategory.delete();
        }
        nonCategoriesToDelete.clear();
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
}
