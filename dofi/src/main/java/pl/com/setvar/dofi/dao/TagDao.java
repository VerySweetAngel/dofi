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
    
    public List<Tag> findTags(String criteria){
        return (List<Tag>) getSession().getNamedQuery("findTagsByTagnameAndTaglinkWord")
                .setString("criteria", "%" + criteria + "%")
                .list();
    }
}
