package pl.com.setvar.dofi.dao;
// Generated Sep 9, 2013 9:02:24 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Operations generated by hbm2java
 */
public class Operations  implements java.io.Serializable {


     private int id;
     private Date creationsDate;
     private int operator;
     private int creator;
     private int category;
     private int value;

    public Operations() {
    }

    public Operations(int id, Date creationsDate, int operator, int creator, int category, int value) {
       this.id = id;
       this.creationsDate = creationsDate;
       this.operator = operator;
       this.creator = creator;
       this.category = category;
       this.value = value;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getCreationsDate() {
        return this.creationsDate;
    }
    
    public void setCreationsDate(Date creationsDate) {
        this.creationsDate = creationsDate;
    }
    public int getOperator() {
        return this.operator;
    }
    
    public void setOperator(int operator) {
        this.operator = operator;
    }
    public int getCreator() {
        return this.creator;
    }
    
    public void setCreator(int creator) {
        this.creator = creator;
    }
    public int getCategory() {
        return this.category;
    }
    
    public void setCategory(int category) {
        this.category = category;
    }
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }




}


