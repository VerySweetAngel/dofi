package pl.com.setvar.dofi.converters;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import javax.faces.convert.ConverterException;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * @author tirpitz
 */
public class CategoryConverterTest extends BaseTestWithHibernate {

    private CategoryConverter out = new CategoryConverter();
    private Category expected;

    @BeforeMethod
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();

        String name = "somename";
        expected = new Category(name);
        expected.save();
    }

    /**
     * Test of getAsObject method, of class CategoryConverter.
     */
    @Test
    public void testGetAsObject() {
        Category actual = (Category) out.getAsObject(null, null, expected.getTagname());
        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getTagname(), actual.getTagname());

        actual = (Category) out.getAsObject(null, null, null);
        assertNull(actual);
    }

    /**
     * Test of getAsString method, of class CategoryConverter.
     */
    @Test
    public void getAsString() {
        String actual = out.getAsString(null, null, expected);
        assertEquals(actual, expected.getTagname());

        actual = out.getAsString(null, null, null);
        assertNull(actual);
    }

    /**
     * Test of getAsString method, of class CategoryConverter.
     */
    @Test(expectedExceptions = {ConverterException.class})
    public void getAsStringConverterException() {
        out.getAsString(null, null, out);
    }
}