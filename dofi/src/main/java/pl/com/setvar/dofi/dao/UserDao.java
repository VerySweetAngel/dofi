package pl.com.setvar.dofi.dao;

import pl.com.setvar.dofi.model.User;

// TODO napisać testy jednostkowe.

/**
 * Klasa DAO dla klasy {@link pl.com.setvar.dofi.model.User}.
 *
 * @author tirpitz
 */
public class UserDao extends GenericDao implements UserDaoInterface {

    @Override
    public User findByCredentials(String login, String password) {
        return (User) getSession()
                .createQuery("FROM User U WHERE U.login = :login AND U.password = :password")
                .setString("login", login)
                .setString("password", password)
                .uniqueResult();
    }

    @Override
    public User findByLogin(String login) {
        return (User) getSession().createQuery("FROM User t WHERE t.login = :login")
                .setString("login", login)
                .uniqueResult();
    }
}