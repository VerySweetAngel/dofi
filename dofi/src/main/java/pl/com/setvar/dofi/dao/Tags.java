package pl.com.setvar.dofi.dao;
// Generated Sep 9, 2013 9:02:24 PM by Hibernate Tools 3.2.1.GA



/**
 * Tags generated by hbm2java
 */
public class Tags  implements java.io.Serializable {


     private int id;
     private String tagname;
     private Short category;
     private Integer parent;

    public Tags() {
    }

	
    public Tags(int id, String tagname) {
        this.id = id;
        this.tagname = tagname;
    }
    public Tags(int id, String tagname, Short category, Integer parent) {
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
    public Short getCategory() {
        return this.category;
    }
    
    public void setCategory(Short category) {
        this.category = category;
    }
    public Integer getParent() {
        return this.parent;
    }
    
    public void setParent(Integer parent) {
        this.parent = parent;
    }




}


