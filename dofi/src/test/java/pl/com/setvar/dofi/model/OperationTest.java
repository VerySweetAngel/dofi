package pl.com.setvar.dofi.model;

import java.util.Date;
import java.util.HashSet;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.dao.GenericDao;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;
import static org.testng.Assert.assertEquals;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.model.Operation}.
 * 
 * @author tirpitz
 */
public class OperationTest extends BaseTestWithHibernate{
    
    @Test(groups = "integration")
    public void saveNewOperation() {
        //given
        User u = User.findByLogin("tester");
        Category category = new Category("markiza");
        Tag t1 = new Tag("jaguar");
        Tag t2 = new Tag("giewont");
        HashSet<Tag> tags = new HashSet<Tag>();
        tags.add(t1);
        tags.add(t2);
        GenericDao dao = new GenericDao();
        
        //when
        Operation o = new Operation();
        o.setCategory(category);
        o.setCreator(u);
        o.setOperationDate(new Date());
        o.setCreationDate(new Date());
        o.setOperator(u);
        o.setTags(tags);
        o.setValue(100);
        o.save();

        Operation fromDb = dao.get(Operation.class, o.getId());

        assertEquals(o.getCategory(), fromDb.getCategory());
        assertEquals(o.getCreator(), fromDb.getCreator());
        assertEquals(o.getOperationDate(), fromDb.getOperationDate());
        assertEquals(o.getCreationDate(), fromDb.getCreationDate());
        assertEquals(o.getOperator(), fromDb.getOperator());
        assertEquals(o.getTags(), fromDb.getTags());
        assertEquals(o.getValue(), fromDb.getValue());
  
    }
}
