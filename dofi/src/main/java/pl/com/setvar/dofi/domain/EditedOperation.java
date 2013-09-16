/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.com.setvar.dofi.model.Operation;
import pl.com.setvar.dofi.model.User;

/**
 * Bean edytowanej operacji na liście operacji
 *
 * @author Marta
 */
@ManagedBean
@ViewScoped
public class EditedOperation implements Serializable {

    private User creationDate;

    public User getCreationDate() {
        return creationDate;
    }
    private User operator;

    public User getOperator() {
        return operator;
    }
    private User creator;

    public User getCreator() {
        return creator;
    }
    private User category;

    public User getCategory() {
        return category;
    }
    private User value;

    public User getValue() {
        return value;
    }
    private User tags;

    public User getTags() {
        return tags;
    }
}
