package pl.com.setvar.dofi.model;

import java.io.Serializable;
import java.util.List;
import pl.com.setvar.dofi.dao.UserDao;

/**
 * użytkownik systemu
 * @author tirpitz
 */
public class User implements Serializable {

    private int id = 0;
    private String login = "";
    private String password = "";
    private String realName = "";
    private String email = "";
    private boolean isAdmin = false;
    
    public User() {
    }
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static List<User> findAll(){
        return new UserDao().findAll(User.class);
    }
    
    public boolean loadIfExistsByCredentials(){
        UserDao dao = new UserDao();
        User fromDb = dao.findByCredentials(login, password);
        if(fromDb == null){
            return false;
        }
        id = fromDb.id;
        realName = fromDb.realName;
        email = fromDb.email;
        isAdmin = fromDb.isAdmin;
        return true;
    }
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName the realName to set
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
