package pl.com.setvar.dofi.domain;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author tirpitz
 */
public class SettingsTest {
    
    private Settings out = new Settings();
    
    @Test
    public void passwordSettings(){
        String oldPassword = "WERTEGDG";
        String newPassword = "56456456";
        SessionUser su = new SessionUser();
        out.setSessionUser(su);
        su.setPassword(oldPassword);
        
        // stare hasło musi zostać podane
        String badOldPassoword = "QEWEERER";
        out.setOldPassword(badOldPassoword);
        out.setNewPassword(newPassword);
        out.setRepeatedPassword(newPassword);
   
// TODO
//        sprawdzić, czy pojawił się msg o błędzie
//        mock musi łapać, jaka wiadomość została rzucona
        
        // TODO nowe hasło musi być powtórzone
        
    }
}