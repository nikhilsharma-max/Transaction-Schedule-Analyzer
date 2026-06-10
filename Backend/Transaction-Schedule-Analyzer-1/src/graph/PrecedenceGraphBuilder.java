package graph;

import java.util.List;
import models.Conflict;
import models.Operation;

public class PrecedenceGraphBuilder {

    public Graph buildGraph(
            List<Operation> operations,
            List<Conflict> conflicts) {

        Graph graph = new Graph();

        // Add all transactions as vertices
        for (Operation operation : operations) {
            graph.addVertex(operation.getTransactionId());
        }

        // Add conflict edges
        for (Conflict conflict : conflicts) {
            graph.addEdge(
                    conflict.getFromTransactionId(),
                    conflict.getToTransactionId()
            );
        }

        return graph;
    }
}