package pl.com.setvar.dofi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import pl.com.setvar.dofi.dao.DaoFactory;
import pl.com.setvar.dofi.dao.GenericDaoInterface;

// TODO dopisać dokumentację.
// TODO dopisać testy.

/**
 * Klasa operacji księgowej.
 *
 * @author tirpitz-verus
 */
public class Operation implements java.io.Serializable {

    private int id;
    private Date creationDate;
    private User operator;
    private User creator;
    private Category category;
    private int value;
    private Set<Tag> tags = new HashSet<Tag>(0);
    
    protected transient GenericDaoInterface dao = DaoFactory.getDao(Operation.class);

    public Operation() {
    }

    /**
     * metoda sprawdza, czy wprowadzono jakieś dane, na podstawie wartości, operatora i kategorii
     */
    public boolean anyDataEntered() {
        if (value != 0 & category != null & operator != null) {
            return true;
        }
        return false;
    }

    /**
     * natychmiastowy zapis do bazy danych
     */
    public void save() {
        dao.replicate(this);
    }

    /**
     * usunięcie operacji
     */
    public void delete() {
        dao.delete(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return (Date) this.creationDate.clone();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = (Date) creationDate.clone();
    }

    public User getOperator() {
        return this.operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public User getCreator() {
        return this.creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the tags
     */
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
