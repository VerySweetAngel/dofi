package pl.com.setvar.dofi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import pl.com.setvar.dofi.dao.CategoryDao;
import pl.com.setvar.dofi.dao.CategoryDaoInterface;

// TODO dorobić testy
/**
 * Klasa kategorii - taga, mającego wartość {@code category} równą {@code true}.
 *
 * @author tirpitz-verus
 */
public class Category implements java.io.Serializable {

    /**
     * Klucz główny.
     */
    private int id;
    /**
     * Nazwa katoegorii.
     */
    private String name;
    /**
     * Czy ten tag jest kategorią
     */
    private boolean category = true;
    /**
     * Kategoria nadrzędna.
     */
    private Category parent;
    /**
     * Wiązania kategorii ze słowami.
     */
    private Set<Taglink> links = new HashSet<Taglink>(); // TODO zrobić klasę CategoryLinks
    /**
     * Powiązane z tą kategorią operacje.
     */
    private Set<Operation> operations = new HashSet<Operation>();
    /**
     * Objekt do wykonywania operacji na bazie danych.
     */
    protected transient CategoryDaoInterface dao = new CategoryDao();

    /**
     * Konstruktor bezargumentowy.
     */
    public Category() {
    }

    /**
     * Konstruktor, tworzący kategorię o zadanej nazwie.
     *
     * @param name nazwa nowej kategorii
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * Metoda usówa tylko te kategorie, które nie mają powiązanych żadnych operacji.
     */
    public void delete() {
        if (operations.isEmpty()) {
            // TODO należy usunąć linki, jeżeli są
            dao.delete(this);
        }
    }

    /**
     * Metoda zwraca kategorię o zadanej nazwie. Jeżeli nie ma takiej w bazie danych, zostanie utworzona nowa.
     *
     * @param name nazwa kategorii do wyszukania
     * @return kategoria o zadanej nazwie
     */
    public static Category findByName(String name) {
        CategoryDaoInterface dao = new CategoryDao();
        Category category;
        category = dao.findByName(name);
        if (category == null) {
            category = new Category(name);
            category.category = true;
            dao.save(category);
        }
        return category;
    }

    /**
     * Funkcja zwraca listę wszytkich kategorii.
     *
     * @return lista wszystkich kategorii
     */
    public static ArrayList<Category> listAll() {
        CategoryDaoInterface dao = new CategoryDao();
        return new ArrayList<Category>(dao.listAll());
    }
}
