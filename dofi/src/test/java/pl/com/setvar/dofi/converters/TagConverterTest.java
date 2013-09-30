package pl.com.setvar.dofi.converters;

import javax.faces.convert.ConverterException;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * @author tirpitz
 */
public class TagConverterTest extends BaseTestWithHibernate {

    private TagConverter out = new TagConverter();
    private Tag expected;

    @BeforeMethod
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();

        String name = "somename";
        expected = new Tag(name);
        expected.save();
    }

    /**
     * Test of getAsObject method, of class TagConverter.
     */
    @Test
    public void testGetAsObject() {
        Tag actual = (Tag) out.getAsObject(null, null, expected.getTagname());
        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getTagname(), actual.getTagname());

        actual = (Tag) out.getAsObject(null, null, null);
        assertNull(actual);
    }

    /**
     * Test of getAsString method, of class TagConverter.
     */
    @Test
    public void testGetAsString() {
        String actual = out.getAsString(null, null, expected);
        assertEquals(actual, expected.getTagname());

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