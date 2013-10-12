package pl.com.setvar.dofi.dao;

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
     * @param <T> typ interfejsu DAO
     * @param klass klasa modelu
     * @return implementacja interfejsu DAO
     */
    public static <T> T getDao(Class klass) {
        if (klass == null) {
            throw new NullPointerException("klass cannot be null");
        }
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
