/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.model;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import pl.com.setvar.dofi.dao.UserDao;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 *
 * @author tirpitz
 */
public class UserTests extends BaseTestWithHibernate {
    
    /**
     *test sprawdza, czy findAll zwróci przynajmniej dwóch userów (admin i tester)
     */
    @Test
    public void testFindAll() {
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
        assertTrue(adminPresent, "brak użytkownika admin");
        assertTrue(testerPresent, "brak użytkownika tester");
    }

    /**
     * test sprawdza, czy można utworzyć usera i go zalogować
     */
    @Test
    public void saveAndLogMeIn() {
        String login = "sdfsdf";
        String password = "dsdwedw";
        String email = "dsdwedw@com.pl";
        String realName = "sdf sfdsd";
        boolean isAdmin = false;
        UserDao dao = new UserDao();
        
        User expected = new User(login, password);
        expected.setEmail(email);
        expected.setIsAdmin(isAdmin);
        expected.setRealName(realName);
        dao.save(expected);
        
        User actual = new User(login, password);
        assertTrue(actual.loadIfExistsByCredentials(), "zapisany user powinen dać się zalogować");
        assertEquals(actual.getLogin(), expected.getLogin());
        assertEquals(actual.getPassword(), expected.getPassword());
        assertEquals(actual.getEmail(), expected.getEmail());
        assertEquals(actual.getRealName(), expected.getRealName());
        assertEquals(actual.isIsAdmin(), expected.isIsAdmin());
    }

}