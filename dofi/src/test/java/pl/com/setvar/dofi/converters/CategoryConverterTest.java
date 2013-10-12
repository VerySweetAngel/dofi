package pl.com.setvar.dofi.converters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertNull;
import org.testng.annotations.BeforeMethod;
import javax.faces.convert.ConverterException;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.converters.CategoryConverter}.
 *
 * @author tirpitz
 */
public class CategoryConverterTest extends BaseTestWithHibernate {

    private CategoryConverter out = new CategoryConverter();
    private Category expected = new Category("somename");

    @BeforeMethod(groups = "integration")
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();
        expected.save();
    }

    @Test(groups = "integration")
    public void getAsObjectOk() {
        //given
        String tagname = expected.getTagname();
        
        //when        
        Category actual = (Category) out.getAsObject(null, null, tagname);
        
        //than
        assertThat(actual.getId(), is(expected.getId()));
        assertThat(actual.getTagname(), is(expected.getTagname()));
    }

    @Test(groups = "integration")
    public void getAsObjectBad() {
        //given
        String tagname = null;
        
        //when        
        Category actual = (Category) out.getAsObject(null, null, tagname);
        
        //than
        assertNull(actual);
    }

    @Test
    public void getAsStringOk() {
        //given
        Category category = expected;
        
        //when
        String actual = out.getAsString(null, null, category);
        
        //than
        assertThat(actual, is(expected.getTagname()));
    }

    @Test
    public void getAsStringBad() {
        //given
        Category category = null;
        
        //when
        String actual = out.getAsString(null, null, category);
        
        //than
        assertNull(actual);
    }

    @Test(expectedExceptions = ConverterException.class)
    public void getAsStringConverterException() {
        //given
        Object category = this;
        
        //when
        out.getAsString(null, null, category);
    }
}