package pl.com.setvar.dofi.converters;

import java.util.HashSet;
import java.util.Set;
import javax.faces.convert.ConverterException;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * @author tirpitz
 */
public class TagSetConverterTest extends BaseTestWithHibernate {
    
    private TagSetConverter out = new TagSetConverter();
    private Set<Tag> expected0 = new HashSet<Tag>(0);
    private Set<Tag> expected1;
    private Set<Tag> expected2;
    private Tag tag1;
    private Tag tag2;
    private String name1 = "somename1";
    private String name2 = "somename2";

    @BeforeMethod
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();

        tag1 = new Tag(name1);
        tag1.save();
        tag2 = new Tag(name2);
        tag2.save();
        
        expected1 = new HashSet<Tag>();
        expected1.add(tag1);
        
        expected2 = new HashSet<Tag>();
        expected2.add(tag1);
        expected2.add(tag2);
    }
    
    /**
     * Test of getAsObject method, of class TagSetConverter.
     */
    @Test
    public void testGetAsObject() {
        Set<Tag> actual = (Set<Tag>) out.getAsObject(null, null, "");
        assertEquals(actual, expected0);
        
        actual = (Set<Tag>) out.getAsObject(null, null, name1);
        assertEquals(actual, expected1);
        
        actual = (Set<Tag>) out.getAsObject(null, null, String.format("%s %s", name1, name2));
        assertEquals(actual, expected2);

        actual = (Set<Tag>) out.getAsObject(null, null, null);
        assertNull(actual);
    }

    /**
     * Test of getAsString method, of class TagSetConverter.
     */
    @Test
    public void testGetAsString() {
        String actual = out.getAsString(null, null, expected0);
        assertEquals(actual, "");
        
        actual = out.getAsString(null, null, expected1);
        assertTrue(actual.contains(name1));
        assertFalse(actual.contains(" "));
        
        actual = out.getAsString(null, null, expected2);
        assertTrue(actual.contains(name1));
        assertTrue(actual.contains(name2));
        assertTrue(actual.contains(" "));

        actual = out.getAsString(null, null, null);
        assertNull(actual);
    }
    
    /**
     * Test of getAsString method, of class TagSetConverter.
     */
    @Test(expectedExceptions = {ConverterException.class})
    public void testGetAsStringConverterException() {
        out.getAsString(null, null, out);
    }
}