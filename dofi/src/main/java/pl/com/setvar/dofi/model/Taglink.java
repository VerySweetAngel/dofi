package pl.com.setvar.dofi.model;

/**
 * wiązanie tagów ze słowami
 * @author tirpitz-verus
 */
public class Taglink implements java.io.Serializable {


     private int id;
     private String word;
     private Tag tag;

    public Taglink() {
    }

    public Taglink(int id, String word, Tag tag) {
       this.id = id;
       this.word = word;
       this.tag = tag;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getWord() {
        return this.word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    public Tag getTag() {
        return this.tag;
    }
    
    public void setTag(Tag tag) {
        this.tag = tag;
    }




}


