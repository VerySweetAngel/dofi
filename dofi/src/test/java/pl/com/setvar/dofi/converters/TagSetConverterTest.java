package pl.com.setvar.dofi.converters;

import java.util.HashSet;
import java.util.Set;
import javax.faces.convert.ConverterException;
import org.testng.annotations.BeforeMethod;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * Test klasy {@link pl.com.setvar.dofi.converters.TagSetConverter}.
 * 
 * @author tirpitz
 */
public class TagSetConverterTest extends BaseTestWithHibernate {
    
    private TagSetConverter out = new TagSetConverter();
    private Set<Tag> emptySet = new HashSet<Tag>(0);
    private Set<Tag> setIthOneTag = new HashSet<Tag>();
    private Set<Tag> setWithManyTags = new HashSet<Tag>();
    private Tag tag1 = new Tag("somename1");
    private Tag tag2 = new Tag("somename2");
    private String oneTag = tag1.getTagname();
    private String manyTags = String.format("%s %s", tag1.getTagname(), tag2.getTagname());
    
    @BeforeMethod
    public void setUp() {
        setIthOneTag.add(tag1);
        setWithManyTags.add(tag1);
        setWithManyTags.add(tag2);
    }
    
    @BeforeMethod(groups = "integration")
    public void setUpForIntegration() {
        tag1.save();
        tag2.save();
    }
    
    @Test(groups = "integration")
    public void getAsObjectEmpty() {
        //given
        String tagsAsString = "";
        
        //when
        Set<Tag> actual = (Set<Tag>) out.getAsObject(null, null, tagsAsString);
        
        //than        
        assertThat(actual, is(emptySet));
    }
    
    @Test(groups = "integration")
    public void getAsObjectOneTag() {
        //given
        String tagsAsString = oneTag;
        
        //when
        Set<Tag> actual = (Set<Tag>) out.getAsObject(null, null, tagsAsString);
        
        //than        
        assertThat(actual, is(setIthOneTag));
    }
        
    @Test(groups = "integration")
    public void getAsObjectManyTags() {
        //given
        String tagsAsString = manyTags;
        
        //when
        Set<Tag> actual = (Set<Tag>) out.getAsObject(null, null, tagsAsString);
        
        //than        
        assertThat(actual, is(setWithManyTags));
    }

    @Test(groups = "integration")
    public void getAsObjectNull() {
        //given
        String tagsAsString = null;
        
        //when
        Set<Tag> actual = (Set<Tag>) out.getAsObject(null, null, tagsAsString);
        
        //than        
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void getAsStringEmpty() {
        //given
        Set<Tag> tags = emptySet;
        
        //when
        String actual = out.getAsString(null, null, tags);
        
        //than
        assertThat(actual, is(""));
    }
        
    @Test
    public void getAsStringOneTag() {
        //given
        Set<Tag> tags = setIthOneTag;
        
        //when
        String actual = out.getAsString(null, null, tags);
        
        //than
        assertThat(actual, containsString(tag1.getTagname()));
        assertThat(actual, not(containsString(" ")));
    }
    
    @Test
    public void getAsStringManyTags() {
        //given
        Set<Tag> tags = setWithManyTags;
        
        //when
        String actual = out.getAsString(null, null, tags);
        
        //than
        assertThat(actual, containsString(tag1.getTagname()));
        assertThat(actual, containsString(tag2.getTagname()));
        assertThat(actual, containsString(" "));
    }

    @Test
    public void getAsStringNull() {
        //given
        Set<Tag> tags = null;
        
        //when
        String actual = out.getAsString(null, null, tags);
        
        //than
        assertThat(actual, is(nullValue()));
    }
    
    @Test(expectedExceptions = {ConverterException.class})
    public void testGetAsStringConverterException() {
        //given
        Object tags = this;
        
        //when
        String actual = out.getAsString(null, null, tags);
    }
}