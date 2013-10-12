package pl.com.setvar.dofi.converters;

import javax.faces.convert.ConverterException;
import static org.testng.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.converters.TagConverter}.
 *
 * @author tirpitz
 */
public class TagConverterTest extends BaseTestWithHibernate {

    private TagConverter out = new TagConverter();
    private Tag expected = new Tag("name");

    @BeforeMethod(groups = "integration")
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();
        expected.save();
    }

    @Test(groups = "integration")
    public void testGetAsObject() {
        //given
        String tagname = expected.getTagname();
        
        //when
        Tag actual = (Tag) out.getAsObject(null, null, tagname);
        
        //than
        assertThat(actual.getId(), is(expected.getId()));
        assertThat(actual.getTagname(), is(expected.getTagname()));
    }

    @Test(groups = "integration")
    public void testGetAsObjectBad() {
        //given
        String tagname = null;
        
        //when
        Tag actual = (Tag) out.getAsObject(null, null, tagname);
        
        //than
        assertNull(actual);
    }

    @Test
    public void testGetAsString() {
        //given
        Tag tag = expected;
        
        //when
        String actual = out.getAsString(null, null, tag);
        
        //than
        assertThat(actual, is(expected.getTagname()));
    }

    @Test
    public void testGetAsStringBad() {
        //given
        Tag tag = null;
        
        //when
        String actual = out.getAsString(null, null, tag);
        
        //than
        assertNull(actual);
    }

    @Test(expectedExceptions = ConverterException.class)
    public void testGetAsStringConverterException() {
        //given
        Object tag = this;
        
        //when
        String actual = out.getAsString(null, null, tag);
    }
}