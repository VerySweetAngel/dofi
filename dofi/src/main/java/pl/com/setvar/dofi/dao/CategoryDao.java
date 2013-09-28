package pl.com.setvar.dofi.dao;

import java.util.List;
import pl.com.setvar.dofi.model.Category;

// TODO testy
/**
 * Klasa DAO dla klasy {@link pl.com.setvar.dofi.model.Category}.
 *
 * @author tirpitz
 */
public class CategoryDao extends GenericDao implements CategoryDaoInterface {

    @Override
    public Category findByName(String tagname) {
        return (Category) getSession().createQuery("FROM Tag t WHERE t.tagname = :tagname AND t.category = :category")
                .setString("tagname", tagname)
                .setParameter("category", true)
                .uniqueResult();
    }

    @Override
    public List<Category> listAll() {
        return (List<Category>) getSession().createQuery("FROM Tag t WHERE t.category = :category")
                .setParameter("category", true)
                .list();
    }

    @Override
    public List<Category> find(String criteria) {
        return (List<Category>) getSession().getNamedQuery("findByTagnameAndTaglinkWord")
                .setString("criteria", String.format("%1$s%2$s%1$s", "%", criteria))
                .list();
    }
}
