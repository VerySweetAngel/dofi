package pl.com.setvar.dofi.model;

// TODO dopisać dokumentację

/**
 * Klasa asocjacji tagów i operacji.
 *
 * @author tirpitz-verus
 */
public class OperationTag implements java.io.Serializable {

    private int id;
    private Tag tag;
    private Operation operation;

    public OperationTag() {
    }

    public OperationTag(int id, Tag tag, Operation operation) {
        this.id = id;
        this.tag = tag;
        this.operation = operation;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
