package pl.com.setvar.dofi.domain;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.MessageAdder;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.domain.Settings}.
 * 
 * @author tirpitz
 */
public class SettingsTest extends BaseTestWithHibernate {
    
    private Settings out = new Settings();
    private String oldPassword = "WERTEGDG";
    private String newPassword = "56456456";
    private String badOldPassoword = "QEWEERER";
    private SessionUser sessionUser = when(mock(SessionUser.class).getPassword()).thenReturn(oldPassword).getMock();
    @Mock
    private MessageAdder messageAdder;
    
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        out = new Settings();
        out.setSessionUser(sessionUser);
        out.messageAdder = messageAdder;
    }
    
    @Test
    public void clearPasswordsAfterRequest() {
        //given
        out.setNewPassword(newPassword);
        out.setRepeatedPassword(newPassword);
        out.setOldPassword(badOldPassoword);
        
        //when
        out.savePasswordChange();
        
        //than
        assertThat(out.getNewPassword(), is(""));
        assertThat(out.getRepeatedPassword(), is(""));
        assertThat(out.getOldPassword(), is(""));
    }
    
    @Test
    public void badOldPassword() {
        //given
        out.setOldPassword(badOldPassoword);
        out.setNewPassword(newPassword);
        out.setRepeatedPassword(newPassword);
        
        //when
        out.savePasswordChange();
        
        //than
        verify(sessionUser, never()).setEnteredPassword(newPassword);
        verify(sessionUser, never()).save();
        verify(messageAdder, never()).addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
        verify(messageAdder).addErrorMessage(Bundles.I18N_SETTINGS, "userSettingsSaveError", "badPassword");
    }
    
    @Test
    public void badRepeatedPassword() {
        //given
        out.setOldPassword(oldPassword);
        out.setNewPassword(newPassword);
        out.setRepeatedPassword(oldPassword);
        
        //when
        out.savePasswordChange();
        
        //than
        verify(sessionUser, never()).setEnteredPassword(newPassword);
        verify(sessionUser, never()).save();
        verify(messageAdder, never()).addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
        verify(messageAdder).addErrorMessage(Bundles.I18N_SETTINGS, "userSettingsSaveError", "badRepeatedPassword");
    }
    
    @Test
    public void changePassword() {
        //given
        out.setOldPassword(oldPassword);
        out.setNewPassword(newPassword);
        out.setRepeatedPassword(newPassword);
        
        //when
        out.savePasswordChange();
        
        //than
        verify(sessionUser).setPassword(newPassword);
        verify(sessionUser).save();
        verify(messageAdder).addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
    }
      
    @Test(groups = "integration")
    public void tags(){
        //given
        Category cat = new Category("cat1");
        cat.save();
        Tag tag = new Tag("tag1");
        tag.save();
        
        //when
        List<Tag> tags = out.tags();
        
        //than
        assertThat(tags, hasItem(tag));
        assertThat(tags, hasItem(cat));
        assertThat(tags, hasSize(2));
    }
    
    @Test
    public void deleteTag(){
        //given
        Tag t = new Tag();
        out.tags.add(t);
        
        //when
        out.deleteTag(t);
        
        //than
        assertThat(out.tagsToDelete, hasItem(t));
        assertThat(out.tags, not(hasItem(t)));
    }
    
    @Test
    public void addCategory(){
        //when
        out.addCategory();
        
        //than
        assertThat(out.tagsToDelete, is(empty()));
        assertThat(out.tags, is(not(empty())));
    }
    
    @Test
    public void addTag(){
        //when
        out.addTag();
        
        //than
        assertThat(out.tagsToDelete, is(empty()));
        assertThat(out.tags, is(not(empty())));
    }
       
    @Test
    public void saveTags(){
        //given
        Tag tag = mock(Tag.class);
        out.tags.add(tag);
        Tag tagToDel = mock(Tag.class);
        out.tagsToDelete.add(tagToDel);
        
        //when
        out.saveTags();
        
        //than
        verify(tag).save();
        verify(tagToDel).delete();
        assertThat(out.tagsToDelete, is(empty()));
        assertThat(out.tags, hasItem(tag));
    }
}