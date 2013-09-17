/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

    public Tag findByTagname(String tagname) {
        return (Tag) getSession().createQuery("FROM Tag t WHERE t.tagname = :tagname")
                .setString("tagname", tagname)
                .uniqueResult();
    }

    public Set<Tag> getSetByTagnames(String tagnames) {
        StringTokenizer st = new StringTokenizer(tagnames);
        Criteria criteria = getSession().createCriteria(Tag.class);
        while (st.hasMoreTokens()){
            String tagname  = st.nextToken();
            criteria.add(Restrictions.eq("tagname", tagname));
        }
        return new HashSet(criteria.list());
    }

    public Tag findCategoryByTagname(String tagname) {
        return (Tag) getSession().createQuery("FROM Tag t WHERE t.tagname = :tagname AND t.category = true")
                .setString("tagname", tagname)
                .uniqueResult();
    }
}
