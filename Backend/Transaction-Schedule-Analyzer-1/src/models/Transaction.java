package models;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private final int transactionId;
    private final List<Operation> operations;

    public Transaction(int transactionId) {
        this.transactionId = transactionId;
        this.operations = new ArrayList<>();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", operations=" + operations +
                '}';
    }
}