package models;

public class Operation {
    private OperationType operationType;
    private int transactionId;
    private String dataItem;

    public Operation(OperationType operationType, int transactionId, String dataItem) {
        this.operationType = operationType;
        this.transactionId = transactionId;
        this.dataItem = dataItem;
    }

    // Getters and setters  -- Setters are commented out to make the Operation class immutable
    public OperationType getOperationType() {
        return operationType;
    }   
    // public void setOperationType(OperationType operationType) {
    //     this.operationType = operationType;
    // }
    public int getTransactionId() {
        return transactionId;
    }
    // public void setTransactionId(int transactionId) {
    //     this.transactionId = transactionId; 
    // }
    public String getDataItem() {
        return dataItem;
    }
    // public void setDataItem(String dataItem) {
    //     this.dataItem = dataItem;
    // }
    @Override
    public String toString() {
        return operationType.toString().substring(0, 1) + transactionId + "(" + dataItem + ")";
    }
}
