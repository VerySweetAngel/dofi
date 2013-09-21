package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marta
 */
@ManagedBean(name = "editedFinancialPlan")
@SessionScoped
public class FinancialPlan implements Serializable {

    private String category = "";
    private Short weSpend = 50;
    private Short released = 30;
    private Short difference = 20;

    public FinancialPlan() {}
    public FinancialPlan(String category, short weSpend, short released, short difference) {
        this.category = category;
        this.weSpend = weSpend;
        this.released = released;
        this.difference = difference;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the weSpend
     */
    public Short getWeSpend() {
        return weSpend;
    }

    /**
     * @param weSpend the weSpend to set
     */
    public void setWeSpend(Short weSpend) {
        this.weSpend = weSpend;
    }

    /**
     * @return the released
     */
    public Short getReleased() {
        return released;
    }

    /**
     * @param released the released to set
     */
    public void setReleased(Short released) {
        this.released = released;
    }

    /**
     * @return the difference
     */
    public Short getDifference() {
        return difference;
    }

    /**
     * @param difference the difference to set
     */
    public void setDifference(Short difference) {
        this.difference = difference;
    }
}
