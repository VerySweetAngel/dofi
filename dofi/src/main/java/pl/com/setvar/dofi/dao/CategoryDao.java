package pl.com.setvar.dofi.dao;

// TODO testy jednostkowe

import pl.com.setvar.dofi.model.Category;

/**
 * Klasa DAO dla klasy {@link pl.com.setvar.dofi.model.Category}.
 *
 * @author tirpitz
 */
public class CategoryDao extends TagDao implements TagDaoInterface {

    @Override
    public Category findByTagname(String tagname) {
        return (Category) getSession().createQuery("FROM Category t WHERE t.tagname = :tagname")
                .setString("tagname", tagname)
                .uniqueResult();
    }
}
