package pl.com.setvar.dofi.model;

import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * Testy dla klasy {@link pl.com.setvar.dofi.model.User}.
 * 
 * @author tirpitz
 */
public class UserTest extends BaseTestWithHibernate {
    
    @Test(groups = "integration")
    public void hasBasicUsers() {
        //when
        List<User> result = User.findAll();
        boolean adminPresent = false;
        boolean testerPresent = false;
        for(User user : result){
            String login = user.getLogin();
            boolean admin = user.isIsAdmin();
            if(admin && login.equals("admin"))
                adminPresent = true;
            if(!admin & login.equals("tester"))
                testerPresent = true;
        }
        
        //than
        assertTrue(adminPresent, "brak użytkownika admin");
        assertTrue(testerPresent, "brak użytkownika tester");
    }

    @Test(groups = "integration")
    public void saveAndLogMeIn() {
        //given
        User expected = new User("sdfsdf", "dsdwedw");
        expected.setEmail("dsdwedw@com.pl");
        expected.setIsAdmin(false);
        expected.setRealName("sdf sfdsd");
        expected.save();
        
        //than
        User actual = new User(expected.getLogin(), expected.getPassword());
        boolean isLoggedIn = actual.loadIfExistsByCredentials();
        
        //than
        assertTrue(isLoggedIn, "zapisany user powinen dać się zalogować");
        assertThat(actual.getLogin(), is(expected.getLogin()));
        assertThat(actual.getPassword(), is(expected.getPassword()));
        assertThat(actual.getRealName(), is(expected.getRealName()));
        assertThat(actual.isIsAdmin(), is(expected.isIsAdmin()));
    }
}
