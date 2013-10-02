package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.Operation;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.model.User;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

// TODO Onapisać testy jednostkowe.
// TODO dopisac dokumentację.

/**
 *
 * @author tirpitz
 */
@ManagedBean
@ViewScoped
public class Operations extends BaseBackingBean implements Serializable {

    private List<Operation> operationsList;
    private List<User> usersList;

    public Operations() {
        usersList = User.findAll();
    }

    public void save() {
        for (Operation operation : operationsList) {
            operation.save();
        }
        messageAdder.addInfoMessage(Bundles.I18N_OPERATIONS, "saved");
    }

    public void addEmpty() {
        if (operationsList == null) {
            operationsList = new ArrayList<Operation>();
        }
        Operation operation = new Operation();
        operation.setCreationDate(new Date());
        operation.setOperator(usersList.get(0));
        operation.setCreator(usersList.get(1));
        operation.setValue(0);
        operation.setTags(new HashSet<Tag>());

        operationsList.add(operation);
    }

    public void delete(Operation operation) {
        operationsList.remove(operation);
        operation.delete();
    }

    public List<Operation> getList() {
        return operationsList;
    }
}
