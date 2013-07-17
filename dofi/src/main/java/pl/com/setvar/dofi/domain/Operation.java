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
    private String creator = "marek";
    private String product = "wrotki";
    private Long value = -100L;

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
     * @return the value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
    }
}
