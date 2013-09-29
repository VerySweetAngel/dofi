package pl.com.setvar.dofi.model;

import pl.com.setvar.dofi.dao.DaoFactory;
import pl.com.setvar.dofi.dao.TagDaoInterface;

// TODO dorobić testy
/**
 * Klasa kategorii - tag'a, mającego wartość {@code category} równą {@code true}.
 *
 * @author tirpitz-verus
 */
public class Category extends Tag implements java.io.Serializable {

    /**
     * Konstruktor bezargumentowy.
     */
    public Category() {
        dao = DaoFactory.getDao(Category.class);
    }

    /**
     * Konstruktor, tworzący kategorię o zadanej nazwie.
     *
     * @param name nazwa nowej kategorii
     */
    public Category(String name) {
        super(name);
        dao = DaoFactory.getDao(Category.class);
    }

    /**
     * Metoda usuwa tylko te kategorie, które nie mają powiązanych żadnych operacji.
     * Usunięte zostają wszytkie powiązania ze słowami.
     */
    @Override
    public void delete() {
        if (getOperations().isEmpty()) {
            dao.deleteWithTaglinks(this);
        }
    }

    /**
     * Metoda zwraca kategorię o zadanej nazwie. Jeżeli nie ma takiej w bazie danych, zostanie utworzona nowa.
     *
     * @param name nazwa kategorii do wyszukania
     * @return kategoria o zadanej nazwie
     */
    public static Category findByName(String name) {
        TagDaoInterface dao = DaoFactory.getDao(Category.class);
        Category category;
        category = dao.findByTagname(name);
        if (category == null) {
            category = new Category(name);
            category.save();
        }
        return category;
    }
}
