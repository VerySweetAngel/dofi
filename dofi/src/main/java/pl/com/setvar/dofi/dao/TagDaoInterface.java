package pl.com.setvar.dofi.dao;

import java.util.List;
import java.util.Set;
import pl.com.setvar.dofi.model.Tag;

// TODO udokumentowac interface

/**
 *
 * @author tirpitz
 */
public interface TagDaoInterface extends GenericDaoInterface{
    boolean CATEGORY_TAG = true;
    boolean NOT_A_CATEGORY_TAG = false;

    /** metoda wyszukuje tagi nie będące kategorią */
    List<Tag> findAvaibleTags(String criteria);

    Tag findByTagname(String tagname);

    /** metoda wyszukuje kategorie, czyli tagi,l będące kategoriami */
    List<Tag> findCategories(String criteria);

    Tag findCategoryByTagname(String tagname);

    List<Tag> findTags(String criteria);

    Set<Tag> getSetByTagnames(String tagnames);

    List<Tag> listAll(boolean category);
    
}
