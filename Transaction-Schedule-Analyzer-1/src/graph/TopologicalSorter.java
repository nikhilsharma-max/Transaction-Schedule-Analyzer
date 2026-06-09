package graph;

import java.util.*;

public class TopologicalSorter {

    public List<Integer> topologicalSort(Graph graph) {

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

        Queue<Integer> queue = new LinkedList<>();

        for (Integer vertex : indegree.keySet()) {
            if (indegree.get(vertex) == 0) {
                queue.offer(vertex);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();

            result.add(current);

            for (Integer neighbor : graph.getNeighbors(current)) {

                indegree.put(
                        neighbor,
                        indegree.get(neighbor) - 1
                );

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}