package pl.com.setvar.dofi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import pl.com.setvar.dofi.dao.GenericDao;

/**
 * klasa operacji księgowej
 * @author tirpitz-verus
 */
public class Operation implements java.io.Serializable {

     private int id;
     private Date creationDate;
     private User operator;
     private User creator;
     private Tag category;
     private int value;
     private Set<Tag> tags = new HashSet<Tag>(0);

    public Operation() {
    }

    public Operation(int id, Date creationDate, User operator, User creator, Tag category, int value, Set<Tag> tags) {
       this.id = id;
       this.creationDate = creationDate;
       this.operator = operator;
       this.creator = creator;
       this.category = category;
       this.value = value;
       this.tags = tags;
    }
   
    /**
     * metoda sprawdza, czy wprowadzono jakieś dane, na podstawie wartości, operatora i kategorii
     */
    public boolean anyDataEntered(){
        if(value != 0 & category != null & operator != null)
            return true;
        return false;
    }
    
    /**
     * natychmiastowy zapis do bazy danych
     */
    public void save(){
        System.out.println(String.format("operation save id: %d", id));
        new GenericDao().replicate(this);
        System.out.println(String.format("operation saved id: %d", id));
    }
    
    /**
     * usunięcie operacji
     */
    public void delete(){
        new GenericDao().delete(this);
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
    public Tag getCategory() {
        return this.category;
    }
    
    public void setCategory(Tag category) {
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


