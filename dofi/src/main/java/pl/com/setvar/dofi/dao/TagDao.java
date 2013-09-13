/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.dao;

import java.util.List;
import pl.com.setvar.dofi.model.Tag;

/**
 *
 * @author tirpitz
 */
public class TagDao extends GenericDao {
    
    private static final boolean CATEGORY_TAG = true;
    private static final boolean NOT_A_CATEGORY_TAG = false;
    
    public List<Tag> findTags(String criteria){
        return findTags(criteria, NOT_A_CATEGORY_TAG);
    }
    
    /** metoda wyszukuje kategorie, czyli tagi,l będące kategoriami */
    public List<Tag> findCategories(String criteria){
        return findTags(criteria, CATEGORY_TAG);
    }
    
    /** metoda wyszukuje tagi nie będące kategorią */
    public List<Tag> findAvaibleTags(String criteria){
        return findTags(criteria, NOT_A_CATEGORY_TAG);
    }
    
    private List<Tag> findTags(String criteria, boolean category){
        return (List<Tag>) getSession().getNamedQuery("findTagsByTagnameAndTaglinkWord")
                .setString("criteria", "%" + criteria + "%")
                .setBoolean("category", category)
                .list();
    }
}
