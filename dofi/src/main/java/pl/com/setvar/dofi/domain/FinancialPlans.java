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
    
    public void setList(ArrayList<FinancialPlan> list) {
        this.list = list;
        
    }public ArrayList<FinancialPlan> getList() {
        return list;
    }

    public FinancialPlans() {
        list.add(new FinancialPlan("Zasilenie",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Oszczędności",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Techniczne",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Rachunki/podatki",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Żywność",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("AGD",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Kosmetyki",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Hobby",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Prezent",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Transport",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Zdrowie",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Artykoły Biurowe",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Kradzież/zguba",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Nauka",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Odzież",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Słodycze",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Rozrywka",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Inne",(short) 50,(short) 30,(short) 20));
        list.add(new FinancialPlan("Pożyczka",(short) 50,(short) 30,(short) 20));
    }
}

