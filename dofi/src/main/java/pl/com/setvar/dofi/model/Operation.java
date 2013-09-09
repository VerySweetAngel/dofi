/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.model;

import java.util.Date;
import java.util.List;

/**
 * operacja finansowa
 * @author tirpitz
 */
public class Operation {
    
    private int id;
    private Date created = new Date();
    private Date happened = new Date();
    private int creatorId;
    private int operatorId;
    private int productId;
    private int value;
    private List tags;
    
    public boolean anyDataEntered(){
        boolean empty = true;
        if(happened != null)
    }
}
