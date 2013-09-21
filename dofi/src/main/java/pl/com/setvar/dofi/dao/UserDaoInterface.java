package pl.com.setvar.dofi.dao;

import pl.com.setvar.dofi.model.User;

// TODO udokumentować interface

/**
 *
 * @author tirpitz
 */
public interface UserDaoInterface extends GenericDaoInterface {

    User findByCredentials(String login, String password);

    User findByLogin(String login);
    
}
