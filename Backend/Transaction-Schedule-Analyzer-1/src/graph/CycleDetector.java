package graph;

import java.util.HashSet;
import java.util.Set;

public class CycleDetector {

    public boolean hasCycle(Graph graph) {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (Integer vertex : graph.getVertices()) {

            if (!visited.contains(vertex)) {

                if (dfs(vertex,
                        graph,
                        visited,
                        recursionStack)) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            int vertex,
            Graph graph,
            Set<Integer> visited,
            Set<Integer> recursionStack) {

        visited.add(vertex);
        recursionStack.add(vertex);

        for (Integer neighbor : graph.getNeighbors(vertex)) {

            if (!visited.contains(neighbor)) {

                if (dfs(neighbor,
                        graph,
                        visited,
                        recursionStack)) {

                    return true;
                }
            }

            else if (recursionStack.contains(neighbor)) {

                return true;
            }
        }

        recursionStack.remove(vertex);

        return false;
    }
}