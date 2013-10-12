package pl.com.setvar.dofi.converters;

import javax.faces.convert.ConverterException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 * Testy klasy {@link pl.com.setvar.dofi.converters.UserConverter}.
 * 
 * @author tirpitz
 */
public class UserConverterTest extends BaseTestWithHibernate {
    
    private UserConverter out = new UserConverter();
    private User userWithLogin = new User("login", "password");
    private String userWithLoginAsString = String.format("[%s]", userWithLogin.getLogin());
    private User userWithRealname = new User("login2", "password", "resalname");
    private String userWithRealnameAsString = String.format("%s [%s]", userWithRealname.getRealName(), userWithRealname.getLogin());

    @BeforeMethod(groups = "integration")
    @Override
    public void setUpMethod() throws Exception {
        super.setUpMethod();
        userWithLogin.save();
        userWithRealname.save();
    }

    @Test(groups = "integration")
    public void testGetAsObjectLogin() {
        //given
        String asString = userWithLoginAsString;
        
        //when
        User actual = (User) out.getAsObject(null, null, asString);
        
        //than
        assertThat(actual, is(userWithLogin));
    }

    @Test(groups = "integration")
    public void testGetAsObjectRealName() {
        //given
        String asString = userWithRealnameAsString;
        
        //when
        User actual = (User) out.getAsObject(null, null, asString);
        
        //than
        assertThat(actual, is(userWithRealname));
    }

    @Test(groups = "integration")
    public void testGetAsObjectNull() {
        //given
        String asString = null;
        
        //when
        User actual = (User) out.getAsObject(null, null, asString);
        
        //than
        assertThat(actual, is(nullValue()));
    }
 
    @Test
    public void testGetAsStringLogin() {
        //given
        User user = userWithLogin;
        
        //when       
        String actual = out.getAsString(null, null, user);
        
        //than
        assertThat(actual, is(userWithLoginAsString));
    }
        
    @Test
    public void testGetAsStringRealname() {
        //given
        User user = userWithRealname;
        
        //when       
        String actual = out.getAsString(null, null, user);
        
        //than
        assertThat(actual, is(userWithRealnameAsString));
    }   

    @Test
    public void testGetAsStringNull() {
        //given
        User user = null;
        
        //when       
        String actual = out.getAsString(null, null, user);
        
        //than
        assertThat(actual, is(nullValue()));
    }
    
    @Test(expectedExceptions = {ConverterException.class})
    public void testGetAsStringConverterException() {
        //given
        Object user = this;
        
        //when       
        out.getAsString(null, null, user);
    }
}