package pl.com.setvar.dofi.model;

import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import pl.com.setvar.dofi.dao.DaoFactory;
import pl.com.setvar.dofi.dao.TagDaoInterface;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.model.Operation}.
 *
 * @author tirpitz
 */
public class TagTest extends BaseTestWithHibernate {

    @Test(groups = "integration")
    public void getSetByTagnamesSpace() {
        //given 
        String nazwyTagów = " ";

        //when
        Set<Tag> setTag = Tag.getSetByTagnames(nazwyTagów);

        //than
        assertThat(setTag, is(empty()));
    }

    @Test(groups = "integration")
    public void getSetByTagnamesEmpty() {
        //given 
        String nazwyTagów = "";

        //when
        Set<Tag> setTag = Tag.getSetByTagnames(nazwyTagów);

        //than
        assertThat(setTag, is(empty()));
    }

    @Test(groups = "integration")
    public void getSetByTagnames() {
        //given 
        String nazwaTaga = "nazwataga";
        Tag tag = new Tag(nazwaTaga);
        tag.save();
        
        //when
        Set<Tag> setTag = Tag.getSetByTagnames(nazwaTaga);

        //than
        assertThat(setTag, hasSize(1));
        assertThat(setTag, hasItem(tag));
    }

    @Test(groups = "integration")
    public void findTags() {
        //given
        Tag t1 = new Tag("markiza");
        t1.save();
        Tag t2 = new Tag("jaguar");
        t2.save();
        Tag t3 = new Tag("giewont");
        t3.save();
        Tag t4 = new Tag("jagoda");
        t4.save();
        TagDaoInterface dao = DaoFactory.getDao(Tag.class);

        //when
        List<Tag> result = dao.find("jag");
        
        //than
        assertThat(result, hasSize(2));
    }
}