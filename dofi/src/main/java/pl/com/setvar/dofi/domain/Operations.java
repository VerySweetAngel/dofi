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
 * @author tirpitz
 */
@ManagedBean
@SessionScoped
public class Operations implements Serializable {

    private ArrayList<Operation> list = new ArrayList<Operation>();

    public Operations() {
        for (int i = 0; i < 2; i++) {
            list.add(new Operation());
            
        }
    }

    public void addEmpty() {
        list.add(new Operation());
    }

    public void delete(Operation operationDelete) {
        list.remove(operationDelete);
    }

        /**
         * @return the operations
         */
    

    public ArrayList<Operation> getList() {
        return list;
    }
}