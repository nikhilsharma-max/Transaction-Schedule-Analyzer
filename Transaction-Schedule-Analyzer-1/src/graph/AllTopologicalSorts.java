package graph;

import java.util.*;

public class AllTopologicalSorts {

    public List<List<Integer>> getAllTopologicalOrders(Graph graph) {

        Map<Integer, Integer> indegree = new HashMap<>();

        for (Integer vertex : graph.getVertices()) {
            indegree.put(vertex, 0);
        }

        for (Integer vertex : graph.getVertices()) {
            for (Integer neighbor : graph.getNeighbors(vertex)) {
                indegree.put(
                        neighbor,
                        indegree.get(neighbor) + 1
                );
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                graph,
                indegree,
                new HashSet<>(),
                new ArrayList<>(),
                result
        );

        return result;
    }

    private void backtrack(
            Graph graph,
            Map<Integer, Integer> indegree,
            Set<Integer> visited,
            List<Integer> currentOrder,
            List<List<Integer>> result) {

        boolean foundChoice = false;

        for (Integer vertex : graph.getVertices()) {

            if (!visited.contains(vertex)
                    && indegree.get(vertex) == 0) {

                foundChoice = true;

                visited.add(vertex);
                currentOrder.add(vertex);

                for (Integer neighbor :
                        graph.getNeighbors(vertex)) {

                    indegree.put(
                            neighbor,
                            indegree.get(neighbor) - 1
                    );
                }

                backtrack(
                        graph,
                        indegree,
                        visited,
                        currentOrder,
                        result
                );

                for (Integer neighbor :
                        graph.getNeighbors(vertex)) {

                    indegree.put(
                            neighbor,
                            indegree.get(neighbor) + 1
                    );
                }

                visited.remove(vertex);
                currentOrder.remove(
                        currentOrder.size() - 1
                );
            }
        }

        if (!foundChoice) {

            if (currentOrder.size()
                    == graph.getVertices().size()) {

                result.add(
                        new ArrayList<>(currentOrder)
                );
            }
        }
    }
}