package pl.com.setvar.dofi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import pl.com.setvar.dofi.dao.TagDao;
import pl.com.setvar.dofi.dao.TagDaoInterface;

// TODO napisać testy jednostkowe do klasy.
// TODO udokumentować klasę

/**
 * Klasa taga do opisu operacji.
 * @author tirpitz-verus
 */
public class Tag implements java.io.Serializable {
    
    private int id;
    private String tagname;
    private boolean category = false;
    private Tag parent;
    private Set<Taglink> taglinks = new HashSet<Taglink>();
    private Set<Operation> operations = new HashSet<Operation>();
    
    protected transient TagDaoInterface dao = new TagDao();

    public Tag() {
    }

    public Tag(String tagName) {
        tagname = tagName;
    }

    public void setOperations(Set<Operation> operations){
        this.operations = operations;
    }
    
    public Set<Operation> getOperations(){
        return operations;
    }
    
    public void setTaglinks(Set<Taglink> taglinks){
        this.taglinks = taglinks;
    }
    
    public Set<Taglink> getTaglinks(){
        return taglinks;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagname() {
        return this.tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public boolean isCategory() {
        return this.category;
    }

    public void setCategory(boolean category) {
        this.category = category;
    }

    public Tag getParent() {
        return this.parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }
    
    @Override
    public String toString(){
        String par = (getParent() != null ? String.format(",%s", getParent().getTagname()) : "");
        String cat = (isCategory() ? ",cat" : "");
        return String.format("%s[%d %s %s]", getTagname(), (Integer) getId(), cat, par);
    }

    /** metoda zapisuje obiekt na koniec sesji */
    public void save() {
        dao.replicate(this);
    }

    /** metoda usówa obiekt */
    public void delete() {
        // TODO jeżeli usówamy zwykły tag, to trzeba też usunąć jego powiązania z operacjami
        dao.delete(this);
    }
    
        /** metoda wyszukuje tagi po nazwie, niezależnie  */
    public static Tag findByTagname(String tagname) {
        TagDaoInterface dao = new TagDao();
        return dao.findByTagname(tagname);
    }

    /** funkcja zwraca kolekcję tagów na podstawie zadanych nazw */
    public static Set<Tag> getSetByTagnames(String tagnames) {
        TagDaoInterface dao = new TagDao();
        return dao.getSetByTagnames(tagnames);
    }

    /** metoda zwraca listę wszytstkich tagów nie będących katqegoriami */
    public static ArrayList<Tag> listAll() {
        TagDaoInterface dao = new TagDao();
        return new ArrayList<Tag>(dao.listAll());
    }
}
