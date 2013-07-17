/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tirpitz
 */
@ManagedBean(name = "editedOperation")
@RequestScoped
public class Operation {
    
    private Date created = new Date();
    private Date happened = new Date();
    private String creator = "Marta";
    private String product = "Kawa z mlekiem";
    private Integer value = -100;
    private Short volume = 2;
    private String tagi = "<3";

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return the happened
     */
    public Date getHappened() {
        return happened;
    }

    /**
     * @param happened the happened to set
     */
    public void setHappened(Date happened) {
        this.happened = happened;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    
        /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }
 
    /**
     * @return the volume
     */
    public Short getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String product) {
        this.setVolume(volume);
    }
 
    /**
     * @return the tagi
     */
    public String getTagi() {
        return tagi;
    }

    /**
     * @param tagi the tagi to set
     */
    public void setTagi(String tagi) {
        this.tagi = tagi;
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Short volume) {
        this.volume = volume;
    }
}
