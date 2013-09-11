/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.dao;

import java.util.List;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.model.Taglink;

/**
 *
 * @author tirpitz
 */
public class TagDao extends GenericDao {
    
    public List<Tag> findTags(String criteria){
        return (List<Tag>) getSession().createQuery("SELECT T.tag FROM Taglink T WHERE T.word LIKE :criteria OR T.tag.tagname LIKE :criteria")
                .setString("criteria", "%" + criteria + "%")
                .list();
    }
}
