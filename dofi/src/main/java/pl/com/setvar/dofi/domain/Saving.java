package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Marta
 */
@ManagedBean(name = "editedSaving")
@RequestScoped
public class Saving implements Serializable {

    private int weHave = 20000;
    private String collectThe = "Auto";
    private int missingOutOn = 600;

    public Saving() {
    }

    public Saving(String collectThe, int weHave, int missingOutOn) {
        this.weHave = weHave;
        this.collectThe = collectThe;
        this.missingOutOn = missingOutOn;

    }

    /**
     * @return the weHave
     */
    public int getWeHave() {
        return weHave;
    }

    /**
     * @param weHave the weHave to set
     */
    public void setWeHave(int weHave) {
        this.weHave = weHave;
    }

    /**
     * @return the collectThe
     */
    public String getCollectThe() {
        return collectThe;
    }

    /**
     * @param collectThe the collectThe to set
     */
    public void setCollectThe(String collectThe) {
        this.collectThe = collectThe;
    }

    /**
     * @return the missingOutOn
     */
    public int getMissingOutOn() {
        return missingOutOn;
    }

    /**
     * @param missingOutOn the missingOutOn to set
     */
    public void setMissingOutOn(int missingOutOn) {
        this.missingOutOn = missingOutOn;
    }
}
