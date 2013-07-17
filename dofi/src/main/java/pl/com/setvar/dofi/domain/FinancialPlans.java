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
@ManagedBean(name = "financialPlans")
@SessionScoped
public class FinancialPlans implements Serializable {

    private ArrayList<FinancialPlan> list = new ArrayList<FinancialPlan>();

    /**
     * @return the list
     */
    public ArrayList<FinancialPlan> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<FinancialPlan> list) {
        this.list = list;
    }

    public FinancialPlans() {
        for (int i = 0; i < 18; i++) {
            list.add(new FinancialPlan());

        }
    }
}
