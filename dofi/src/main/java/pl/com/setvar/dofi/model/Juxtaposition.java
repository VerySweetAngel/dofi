package pl.com.setvar.dofi.model;

import pl.com.setvar.dofi.dao.GenericDao;
import pl.com.setvar.dofi.dao.GenericDaoInterface;

// TODO dopisac dokumentację

/**
 * klasa zestawienia - po jakich tagach wyszukiewać operacje
 * @author tirpitz-verus
 */
public class Juxtaposition implements java.io.Serializable {

    private int id;
    private Tag tag;
    private String name;
    protected GenericDaoInterface dao = new GenericDao();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
