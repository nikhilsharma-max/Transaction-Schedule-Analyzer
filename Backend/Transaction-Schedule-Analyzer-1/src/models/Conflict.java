package models;

public class Conflict {

    private final Operation firstOperation;
    private final Operation secondOperation;

    public Conflict(Operation firstOperation, Operation secondOperation) {
        this.firstOperation = firstOperation;
        this.secondOperation = secondOperation;
    }

    public Operation getFirstOperation() {
        return firstOperation;
    }

    public Operation getSecondOperation() {
        return secondOperation;
    }

    public int getFromTransactionId() {
        return firstOperation.getTransactionId();
    }

    public int getToTransactionId() {
        return secondOperation.getTransactionId();
    }

    public String getDataItem() {
        return firstOperation.getDataItem();
    }

    @Override
    public String toString() {
        return firstOperation + " -> " + secondOperation;
    }
}