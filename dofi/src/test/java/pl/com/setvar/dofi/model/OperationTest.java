/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.model;

import java.util.Date;
import java.util.HashSet;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.dao.GenericDao;
import pl.com.setvar.dofi.dao.TagDao;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 *
 * @author tirpitz
 */
public class OperationTest extends BaseTestWithHibernate{
    
    @Test
    public void saveNewOperation() {
        User u = User.findByLogin("tester");
        Tag category = new Tag("markiza");
        Tag t1 = new Tag("jaguar");
        Tag t2 = new Tag("giewont");
//        TagDao tagDao = new TagDao();
//        tagDao.saveOrUpdate(category);
//        tagDao.saveOrUpdate(t1);
//        tagDao.saveOrUpdate(t2);
        HashSet<Tag> tags = new HashSet<Tag>();
        tags.add(t1);
        tags.add(t2);
        
        Operation o = new Operation();
        o.setCategory(category);
        o.setCreator(u);
        o.setCreationDate(new Date());
        o.setOperator(u);
        o.setTags(tags);
        o.setValue(100);
        GenericDao dao = new GenericDao();
        dao.saveOrUpdate(o);
    }
}