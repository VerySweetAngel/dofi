/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.com.setvar.dofi.model.Operation;
import pl.com.setvar.dofi.model.User;

/**
 *
 * @author tirpitz
 */
@ManagedBean
@ViewScoped
public class Operations implements Serializable {

    private List<Operation> operationsList;
    private List<User> usersList;

    public Operations() {
        usersList = User.findAll();
    }
    
    public void save(){
        for(Operation operation : operationsList){
            operation.save();
        }
    }

    public void addEmpty() {
        if(operationsList == null){
            operationsList = new ArrayList<Operation>();
        }
        operationsList.add(new Operation());
    }

    public void delete(Operation operation) {
        operationsList.remove(operation);
        
    }

    public List<Operation> getList() {
        return operationsList;
    }
}