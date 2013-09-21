package pl.com.setvar.dofi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import pl.com.setvar.dofi.dao.TagDao;
import pl.com.setvar.dofi.dao.TagDaoInterface;

// TODO wyciągnąc stąd klasę Category i napisać testy jednostkowe. Dorobić mapowanie hbm.xml. Określić interfejs.
// TODO napisać testy jednostkowe do klasy.
// TODO Określić interfejs.

/**
 * Klasa taga do opisu operacji.
 * @author tirpitz-verus
 */
public class Tag implements java.io.Serializable {

    /** metoda wyszukuje tagi po nazwie, niezależnie  */
    public static Tag findByTagname(String tagname) {
        TagDao tagDao = new TagDao();
        return tagDao.findByTagname(tagname);
    }

    /** funkcja zwraca kolekcję tagów na podstawie zadanych nazw */
    public static Set<Tag> getSetByTagnames(String tagname) {
        TagDao tagDao = new TagDao();
        return tagDao.getSetByTagnames(tagname);
    }

    /** wyszukiwanie kategorii po nazwie */
    public static Tag findByCategoryTagname(String tagname) {
        TagDao tagDao;
        tagDao = new TagDao();
        Tag category;
        category = tagDao.findCategoryByTagname(tagname);
        if (category == null) {
            category = new Tag(tagname);
            category.setCategory(true);
            tagDao.save(category);
        }
        return category;
    }

    /** zwraca listę wszytkich kategorii */
    public static ArrayList<Tag> listAllCategories() {
        TagDao tagDao = new TagDao();
        return new ArrayList<Tag>(tagDao.listAll(TagDao.CATEGORY_TAG));
    }

    /** metoda zwraca listę wszytstkich tagów nie będących katqegoriami */
    public static ArrayList<Tag> listAllTags() {
        TagDao tagDao = new TagDao();
        return new ArrayList<Tag>(tagDao.listAll(TagDao.NOT_A_CATEGORY_TAG));
    }
    
    private int id;
    private String tagname;
    private boolean category = false;
    private Tag parent;
    private Set<Taglink> taglinks = new HashSet<Taglink>();
    private Set<Operation> operations = new HashSet<Operation>();
    
    protected TagDaoInterface dao = new TagDao();

    public Tag() {
    }

    public Tag(String tagName) {
        tagname = tagName;
    }

    public Tag(int id, String tagname) {
        this.id = id;
        this.tagname = tagname;
    }

    public Tag(int id, String tagname, boolean category, Tag parent) {
        this.id = id;
        this.tagname = tagname;
        this.category = category;
        this.parent = parent;
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
        if(isCategory()){
            // przy usówaniu kategorii, nie można usunąc tych kategorii, które mają jakies operacje
            if(operations.isEmpty())
                dao.delete(this);
        }
        // TODO jeżeli usówamy zwykły tag, to trzeba też usunąć jego powiązania z operacjami
        dao.delete(this);
    }
}
