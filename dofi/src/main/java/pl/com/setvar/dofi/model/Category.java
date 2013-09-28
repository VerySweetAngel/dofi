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
        if (getOperations().isEmpty()) {
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
            category.setCategory(true);
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

    /**
     * Metoda zapisuje obiekt na końcu rząania.
     */
    public void save() {
        dao.replicate(this);
    }

    /**
     * @return klucz główny
     */
    public int getId() {
        return id;
    }

    /**
     * @param id klucz główny
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return nazwa kategorii
     */
    public String getName() {
        return name;
    }

    /**
     * @param name nazwa kategorii
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return wartośc kolumny {@code category}
     */
    public boolean isCategory() {
        return category;
    }

    /**
     * @param category wartośc kolumny {@code category}
     */
    public void setCategory(boolean category) {
        this.category = category;
    }

    /**
     * @return katoegoria nadrzędna
     */
    public Category getParent() {
        return parent;
    }

    /**
     * @param parent katoegoria nadrzędna
     */
    public void setParent(Category parent) {
        this.parent = parent;
    }

    /**
     * @return wiązania ze słowami
     */
    public Set<Taglink> getLinks() {
        return links;
    }

    /**
     * @param links wiązania ze słowami
     */
    public void setLinks(Set<Taglink> links) {
        this.links = links;
    }

    /**
     * @return powiązane operacje
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * @param operations powiązane operacje
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
