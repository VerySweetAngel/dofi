package pl.com.setvar.dofi.model;

/**
 * klasa zestawienia - po jakich tagach wyszukiewać operacje
 * @author tirpitz-verus
 * @todo ta klasa powinna przechowywać mapę
 */
public class Juxtaposition implements java.io.Serializable {

     private int id;
     private Tag tag;
     private String name;

    public Juxtaposition() {
    }

    public Juxtaposition(int id, Tag tag, String name) {
       this.id = id;
       this.tag = tag;
       this.name = name;
    }
   
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

