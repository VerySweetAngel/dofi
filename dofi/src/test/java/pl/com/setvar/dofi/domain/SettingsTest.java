package pl.com.setvar.dofi.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.MessageAdder;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.domain.Settings}.
 * 
 * @author tirpitz
 */
public class SettingsTest {
    
    private Settings out = new Settings();
    private String oldPassword = "WERTEGDG";
    private String newPassword = "56456456";
    private String badOldPassoword = "QEWEERER";
    private SessionUser sessionUser = when(mock(SessionUser.class).getPassword()).thenReturn(oldPassword).getMock();
    private MessageAdder messageAdder = mock(MessageAdder.class);
    
    @BeforeMethod(groups = "unit")
    public void setUp() {
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
        out.passwordSettings();
        
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
        out.passwordSettings();
        
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
        out.passwordSettings();
        
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
        out.passwordSettings();
        
        //than
        verify(sessionUser).setPassword(newPassword);
        verify(sessionUser).save();
        verify(messageAdder).addInfoMessage(Bundles.I18N_SETTINGS, "userSettingsSaved");
    }
}