package pl.com.setvar.dofi.model;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.dao.TagDao;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 *
 * @author tirpitz
 */
public class TagAndLinksTest extends BaseTestWithHibernate{
    
    @Test
    public void findTags(){
        Tag t1 = new Tag("markiza");
        Tag t2 = new Tag("jaguar");
        Tag t3 = new Tag("giewont");
        Tag t4 = new Tag("jagoda");
        TagDao tagDao = new TagDao();
        tagDao.saveOrUpdate(t4);
        tagDao.saveOrUpdate(t3);
        tagDao.saveOrUpdate(t2);
        tagDao.saveOrUpdate(t1);
             
        List<Tag> result = tagDao.findAvaibleTags("jag");
        assertTrue((result.size() == 2), "powinny być tylko dwa takie tagi a było " + result.size());
    }
}