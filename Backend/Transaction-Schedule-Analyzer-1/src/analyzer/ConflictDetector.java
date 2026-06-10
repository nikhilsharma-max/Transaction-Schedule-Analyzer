package analyzer;
import java.util.*;
import models.*;
public class ConflictDetector {
    public List<Conflict> detectConflicts(List<Operation> operations){
        List<Conflict> conflicts = new ArrayList<>();
        for(int i = 0; i < operations.size(); i++){
            for(int j = i + 1; j < operations.size(); j++){
                Operation op1 = operations.get(i);
                Operation op2 = operations.get(j);
                if(op1.getTransactionId() != op2.getTransactionId()){
                    if((op1.getOperationType() == OperationType.WRITE || op2.getOperationType() == OperationType.WRITE)){
                        if(op1.getDataItem().equals(op2.getDataItem())){
                            conflicts.add(new Conflict(op1, op2));
                        }
                    }
                }
            }
        }
        return conflicts;
    }
}
