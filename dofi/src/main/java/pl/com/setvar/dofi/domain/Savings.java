/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marta
 */
@ManagedBean(name = "savings")
@SessionScoped
public class Savings implements Serializable {

    private ArrayList<Saving> list = new ArrayList<Saving>();

    /**
     * @return the list
     */
    public void setList(ArrayList<Saving> list) {
        this.list = list;

    }
    
    public ArrayList<Saving> getList() {
        return list;
    }
    public void addEmpty() {
        list.add(new Saving());
    }
    public void delete(Saving savingDelete) {
        list.remove(savingDelete);
    }

    public Savings() {
        list.add(new Saving("Auto:",(short) 20000,(short) 600));
        
    }
}