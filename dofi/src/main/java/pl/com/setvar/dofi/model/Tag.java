package pl.com.setvar.dofi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.com.setvar.dofi.dao.DaoFactory;
import pl.com.setvar.dofi.dao.TagDaoInterface;

// TODO napisać testy jednostkowe do klasy.
// TODO udokumentować klasę

/**
 * Klasa tag'a do opisu operacji.
 * @author tirpitz-verus
 */
public class Tag implements java.io.Serializable {
    
    /**
     * Klucz główny.
     */
    private int id;
    /**
     * Nazwa kategorii.
     */
    protected String tagname;
    /**
     * Kategoria nadrzędna.
     */
    private Tag parent;
    /**
     * Wiązania kategorii ze słowami.
     */
    private Set<Taglink> taglinks = new HashSet<Taglink>();
    /**
     * Powiązane z tą kategorią operacje.
     */
    private Set<Operation> operations = new HashSet<Operation>();
    
        /**
     * Obiekt do wykonywania operacji na bazie danych.
     */
    protected transient TagDaoInterface dao = DaoFactory.getDao(Tag.class);

        /**
     * Konstruktor bezargumentowy.
     */
    public Tag() {
    }

        /**
     * Konstruktor, tworzący tag o zadanej nazwie.
     *
     * @param tagName nazwa nowego tag'a
     */
    public Tag(String tagName) {
        tagname = tagName;
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
    public String getTagname() {
        return tagname;
    }

    /**
     * @param name nazwa kategorii
     */
    public void setTagname(String name) {
        this.tagname = name.toLowerCase();
    }

    /**
     * @return kategoria nadrzędna
     */
    public Tag getParent() {
        return parent;
    }

    /**
     * @param parent kategoria nadrzędna
     */
    public void setParent(Tag parent) {
        this.parent = parent;
    }
    
        /**
     * @return wiązania ze słowami
     */
    public Set<Taglink> getTaglinks() {
        return taglinks;
    }

    /**
     * @param links wiązania ze słowami
     */
    public void setTaglinks(Set<Taglink> links) {
        taglinks = links;
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
    
    /**
     * Metoda zwraca tekstową reprezentację obiektu.
     * @return tagname
     */
    @Override
    public String toString(){
        return tagname;
    }

    /**
     * Metoda zapisuje obiekt na końcu rządania.
     */
    public void save() {
        dao.replicate(this);
    }

    /**
     * Metoda usówa tag razem z jego powiązaniami z operacjami.
     * Usunięte zostają wszytkie powiązania ze słowami.
     */
    public void delete() {
        // TODO jeżeli usówamy zwykły tag, to trzeba też usunąć jego powiązania z operacjami
        dao.deleteWithTaglinks(this);
    }
    
        /** metoda wyszukuje tagi po nazwie, niezależnie  */
    public static Tag findByTagname(String tagname) {
        TagDaoInterface dao = DaoFactory.getDao(Tag.class);
        return dao.findByTagname(tagname);
    }

    /** funkcja zwraca kolekcję tagów na podstawie zadanych nazw */
    public static Set<Tag> getSetByTagnames(String tagnames) {
        TagDaoInterface dao = DaoFactory.getDao(Tag.class);
        return dao.getSetByTagnames(tagnames);
    }

    /** metoda zwraca listę wszytstkich tagów */
    public static ArrayList<Tag> listAll() {
        TagDaoInterface dao = DaoFactory.getDao(Tag.class);
        List<Tag> l = (List<Tag>) dao.findAll(Tag.class);
        return new ArrayList<Tag>(l);
    }
}
