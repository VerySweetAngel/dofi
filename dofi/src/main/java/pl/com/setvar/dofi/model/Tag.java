package pl.com.setvar.dofi.model;

import java.util.Set;
import pl.com.setvar.dofi.dao.TagDao;

/**
 * klasa taga do opisu operacji
 *
 * @author tirpitz-verus
 */
public class Tag implements java.io.Serializable {

    public static Tag findByTagname(String tagname) {
        TagDao tagDao = new TagDao();
        return tagDao.findByTagname(tagname);
    }

    /** funkcja zwraca kolekcję tagów na podstawie zadanych nazw */
    public static Set<Tag> getSetByTagnames(String tagname) {
        TagDao tagDao = new TagDao();
        return tagDao.getSetByTagnames(tagname);
    }

    public static Tag findBysCategoryTagname(String tagname) {
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
    
    private int id;
    private String tagname;
    private boolean category = false;
    private Tag parent;

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
        new TagDao().replicate(this);
    }

    /** metoda usówa obiekt */
    public void delete() {
        // TODO przy usówaniu kategorii, nie można usunąc tych kategorii, które mają jakies operacje
        // TODO jeżeli usówamy zwykły tag, to trzeba też usunąć jego powiązania z operacjami
        // TODO trzeba kaskadowo usówać linki ze łowami
        new TagDao().delete(this);
    }
}
