/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tirpitz
 */
@ManagedBean
@RequestScoped
public class Operations {

    private ArrayList<Operation> list = new ArrayList<Operation>();

    public Operations() {
        for (int i = 0; i < 200; i++) {
            list.add(new Operation());
        }
    }

/**
 * @return the operations
 */
public ArrayList<Operation> getList() {
        return list;
    }
}
