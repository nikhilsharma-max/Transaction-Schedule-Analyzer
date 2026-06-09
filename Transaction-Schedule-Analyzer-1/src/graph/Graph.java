package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int transactionId) {
        adjacencyList.putIfAbsent(transactionId, new HashSet<>());
    }

    public void addEdge(int from, int to) {
        addVertex(from);
        addVertex(to);

        adjacencyList.get(from).add(to);
    }

    public Set<Integer> getNeighbors(int transactionId) {
        return adjacencyList.getOrDefault(
                transactionId,
                new HashSet<>()
        );
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Integer vertex : adjacencyList.keySet()) {
            sb.append(vertex)
              .append(" -> ")
              .append(adjacencyList.get(vertex))
              .append("\n");
        }

        return sb.toString();
    }
}