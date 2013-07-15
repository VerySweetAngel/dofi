/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.dao;

import pl.com.setvar.dofi.model.User;

/**
 *
 * @author tirpitz
 */
public class UserDao extends GenericDao {

    public User findByCredentials(String login, String password) {
        return (User) getSession()
                .createQuery("FROM User U WHERE U.login = :login AND U.password = :password")
                .setString("login", login)
                .setString("password", password)
                .uniqueResult();
    }
}
