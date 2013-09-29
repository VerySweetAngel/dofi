package pl.com.setvar.dofi.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import pl.com.setvar.dofi.model.Tag;

// TODO napisać testy jednostkowe
/**
 * Klasa DAO dla klasy {@link pl.com.setvar.dofi.model.Tag}.
 *
 * @author tirpitz
 */
public class TagDao extends GenericDao implements TagDaoInterface {

    @Override
    public List<Tag> find(String criteria) {
        return (List<Tag>) getSession().getNamedQuery("findByTagnameAndTaglinkWord")
                .setString("criteria", String.format("%1$s%2$s%1$s", "%", criteria))
                .list();
    }

    @Override
    public Tag findByTagname(String tagname) {
        return (Tag) getSession().createQuery("FROM Tag t WHERE t.tagname = :tagname")
                .setString("tagname", tagname)
                .uniqueResult();
    }

    @Override
    public Set<Tag> getSetByTagnames(String tagnames) {
        StringTokenizer st = new StringTokenizer(tagnames);
        if (st.hasMoreTokens() == false) {
            return new HashSet<Tag>();
        }
        Junction junction = Restrictions.disjunction();
        while (st.hasMoreTokens()) {
            String tagname = st.nextToken();
            junction = junction.add(Restrictions.eq("tagname", tagname));
        }
        Criteria criteria = getSession().createCriteria(Tag.class);
        criteria = criteria.add(junction);
        return new HashSet(criteria.list());
    }

    @Override
    public <T extends Tag> void deleteWithTaglinks(T model) {
        delete(model);
        getSession().createQuery("delete Taglink where tag = :tagId")
            .setInteger("tagId", model.getId())
            .executeUpdate();
    }
}
