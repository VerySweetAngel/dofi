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

    public static Set<Tag> getSetByTagnames(String tagname) {
        TagDao tagDao = new TagDao();
        return tagDao.getSetByTagnames (tagname);
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
}
