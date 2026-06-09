package parser;

import java.util.ArrayList;
import java.util.List;
import models.Operation;
import models.OperationType;

public class ScheduleParser {

    public List<Operation> parse(String schedule) {

        List<Operation> operations = new ArrayList<>();

        String[] tokens = schedule.trim().split("\\s+");

        for (String token : tokens) {

            // Validate format like R1(X), W12(Account)
            if (!token.matches("[RW]\\d+\\([A-Za-z0-9_]+\\)")) {
                throw new IllegalArgumentException(
                        "Invalid operation format: " + token);
            }

            // Extract operation type
            OperationType type =
                    (token.charAt(0) == 'R')
                            ? OperationType.READ
                            : OperationType.WRITE;

            // Extract transaction id
            int openParenIndex = token.indexOf('(');

            int transactionId = Integer.parseInt(
                    token.substring(1, openParenIndex)
            );

            // Extract data item
            String dataItem = token.substring(
                    openParenIndex + 1,
                    token.length() - 1
            );

            operations.add(
                    new Operation(
                            type,
                            transactionId,
                            dataItem
                    )
            );
        }

        return operations;
    }
}