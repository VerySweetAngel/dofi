package pl.com.setvar.dofi.dao;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Juxtaposition;
import pl.com.setvar.dofi.model.Operation;
import pl.com.setvar.dofi.model.OperationTag;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.model.Taglink;
import pl.com.setvar.dofi.model.User;

/**
 * @author tirpitz
 */
public class DaoFactoryTest {

    /**
     * Test of getDao method, of class DaoFactory.
     */
    @Test
    public void testGetDao() {
        Object dao = DaoFactory.getDao(Category.class);
        assertTrue(dao instanceof TagDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", Category.class, TagDaoInterface.class, dao.getClass()));

        dao = DaoFactory.getDao(Juxtaposition.class);
        assertTrue(dao instanceof GenericDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", Juxtaposition.class, GenericDaoInterface.class, dao.getClass()));

        dao = DaoFactory.getDao(Operation.class);
        assertTrue(dao instanceof GenericDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", Operation.class, GenericDaoInterface.class, dao.getClass()));

        dao = DaoFactory.getDao(OperationTag.class);
        assertTrue(dao instanceof GenericDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", OperationTag.class, GenericDaoInterface.class, dao.getClass()));

        dao = DaoFactory.getDao(Tag.class);
        assertTrue(dao instanceof TagDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", Tag.class, TagDaoInterface.class, dao.getClass()));

        dao = DaoFactory.getDao(Taglink.class);
        assertTrue(dao instanceof GenericDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", Taglink.class, GenericDaoInterface.class, dao.getClass()));

        dao = DaoFactory.getDao(User.class);
        assertTrue(dao instanceof UserDaoInterface, String.format("dla %s nie zwrócono %s, tylko %s", User.class, UserDaoInterface.class, dao.getClass()));
    }
}