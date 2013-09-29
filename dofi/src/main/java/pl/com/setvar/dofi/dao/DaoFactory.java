package pl.com.setvar.dofi.dao;

// TODO testy

import pl.com.setvar.dofi.model.Category;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.model.User;


/**
 * Klasa produkuje instancję DAO na podstawie klasy proszącej. 
 * @author tirpitz
 */
public class DaoFactory {
    
    /**
     * Funkcja zwraca instancję klasy DAO w zależności od zadanej klasy modelu.
     * @param <T>
     * @param klass
     * @return 
     */
    public static <T> T getDao(Class klass) {
        if (klass.equals(Category.class)) {
            return (T) new CategoryDao();
        } else if (klass.equals(Tag.class)) {
            return (T) new TagDao();
        } else if (klass.equals(User.class)) {
            return (T) new UserDao();
        }
        return (T) new GenericDao();
    } 
}
