package pl.com.setvar.dofi.converters;

import javax.faces.convert.ConverterException;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * @author tirpitz
 */
public class UserConverterTest extends BaseTestWithHibernate {
    
    private UserConverter out = new UserConverter();
    private User expected1;
    private User expected2;

    @BeforeMethod
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();

        expected1 = new User("login", "password");
        expected1.save();
        expected2 = new User("login2", "password");
        expected2.setRealName("resalname");
        expected2.save();
    }

    /**
     * Test of getAsObject method, of class UserConverter.
     */
    @Test
    public void testGetAsObject() {
        User actual = (User) out.getAsObject(null, null, String.format("[%s]", expected1.getLogin()));
        assertEquals(actual, expected1);

        actual = (User) out.getAsObject(null, null, String.format("%s [%s]", expected2.getRealName(), expected2.getLogin()));
        assertEquals(actual, expected2);
        
        actual = (User) out.getAsObject(null, null, null);
        assertNull(actual);
    }

    /**
     * Test of getAsString method, of class UserConverter.
     */
    @Test
    public void testGetAsString() {
        String actual = out.getAsString(null, null, expected1);
        assertEquals(actual, String.format("[%s]", expected1.getLogin()));
        
        actual = out.getAsString(null, null, expected2);
        assertEquals(actual, String.format("%s [%s]", expected2.getRealName(), expected2.getLogin()));

        actual = out.getAsString(null, null, null);
        assertNull(actual);

        try {
            actual = out.getAsString(null, null, out);
        }
        catch (ConverterException exception) {
            // all ok
        }
        catch (Exception exception) {
            fail("powinien pojawić się wyjątek ConverterException");
        }
    }
}