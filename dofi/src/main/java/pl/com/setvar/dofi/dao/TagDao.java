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
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import pl.com.setvar.dofi.model.Tag;

/**
 *
 * @author tirpitz
 */
public class TagDao extends GenericDao {
    
    public static final boolean CATEGORY_TAG = true;
    public static final boolean NOT_A_CATEGORY_TAG = false;
    
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
    
    /** 
     * Zwraca listę tagów spełniających żądane kryteria.
     */
    private List<Tag> findTags(String criteria, boolean category){
        return (List<Tag>) getSession().getNamedQuery("findTagsByTagnameAndTaglinkWord")
                .setBoolean("category", category)
                .setString("criteria", String.format("%%s%", criteria))
                .list();
    }

    public Tag findByTagname(String tagname) {
        return (Tag) getSession().createQuery("FROM Tag t WHERE t.tagname = :tagname")
                .setString("tagname", tagname)
                .uniqueResult();
    }

    public Set<Tag> getSetByTagnames(String tagnames) {
        StringTokenizer st = new StringTokenizer(tagnames);
        if(st.hasMoreTokens() == false){
            return new HashSet<Tag>();
        }
        Junction junction = Restrictions.disjunction();
        while (st.hasMoreTokens()){
            String tagname  = st.nextToken();
            junction = junction.add(Restrictions.eq("tagname", tagname));
        }
        Criteria criteria = getSession().createCriteria(Tag.class);
        criteria = criteria.add(junction);
        return new HashSet(criteria.list());
    }

    public Tag findCategoryByTagname(String tagname) {
        return (Tag) getSession().createQuery("FROM Tag t WHERE t.tagname = :tagname AND t.category = :category")
                .setString("tagname", tagname)
                .setParameter("category", true)
                .uniqueResult();
    }

    public List<Tag> listAll(boolean category) {
        return (List<Tag>) getSession().createQuery("FROM Tag t WHERE t.category = :category")
                .setParameter("category", true)
                .list();
    }
}
