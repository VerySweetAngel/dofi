package pl.com.setvar.dofi.dao;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Juxtaposition;
import pl.com.setvar.dofi.model.Operation;
import pl.com.setvar.dofi.model.OperationTag;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.model.Taglink;
import pl.com.setvar.dofi.model.User;

/**
 *  Testy dla klasy {@link pl.com.setvar.dofi.dao.DaoFactory}.
 * 
 * @author tirpitz
 */
public class DaoFactoryTest {

    @Test
    public void getDaoForCategory() {
        //given
        Class c = Category.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(TagDaoInterface.class));
    }
    
    @Test
    public void getDaoForJuxtaposition() {
        //given
        Class c = Juxtaposition.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(GenericDaoInterface.class));
    }

    @Test
    public void getDaoForOperation() {
        //given
        Class c = Operation.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(GenericDaoInterface.class));
    }

    @Test
    public void getDaoForOperationTag() {
        //given
        Class c = OperationTag.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(GenericDaoInterface.class));
    }

    @Test
    public void getDaoForTag() {
        //given
        Class c = Tag.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(TagDaoInterface.class));
    }

    @Test
    public void getDaoForTaglink() {
        //given
        Class c = Taglink.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(GenericDaoInterface.class));
    }

    @Test
    public void getDaoForUser() {
        //given
        Class c = User.class;
        
        //when
        Object dao = DaoFactory.getDao(c);
        
        //than
        assertThat(dao, instanceOf(UserDaoInterface.class));
    }
}