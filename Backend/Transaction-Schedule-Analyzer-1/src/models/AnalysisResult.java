package models;
import graph.Graph;
import java.util.*;

public class AnalysisResult {

    private final boolean serializable;
    private final List<Conflict> conflicts;
    private final Graph graph;
    private final List<List<Integer>> serialSchedules;

    public AnalysisResult(
            boolean serializable,
            List<Conflict> conflicts,
            Graph graph,
            List<List<Integer>> serialSchedules) {

        this.serializable = serializable;
        this.conflicts = conflicts;
        this.graph = graph;
        this.serialSchedules = serialSchedules;
    }

    public boolean isSerializable() {
        return serializable;
    }

    public List<Conflict> getConflicts() {
        return conflicts;
    }

    public Graph getGraph() {
        return graph;
    }

    public List<List<Integer>> getSerialSchedules() {
        return serialSchedules;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n===== ANALYSIS RESULT =====\n");

        sb.append("Serializable: ")
          .append(serializable ? "YES" : "NO")
          .append("\n\n");

        sb.append("Conflicts:\n");

        if (conflicts.isEmpty()) {
            sb.append("None\n");
        } else {
            for (Conflict conflict : conflicts) {
                sb.append(conflict).append("\n");
            }
        }

        sb.append("\nPrecedence Graph:\n");
        sb.append(graph);

        if (serializable) {

            sb.append("\nAll Valid Serial Schedules:\n");

            if (serialSchedules.isEmpty()) {

                sb.append("None\n");

            } else {

                int count = 1;

                for (List<Integer> schedule : serialSchedules) {

                    sb.append(count++)
                      .append(". ");

                    for (Integer transactionId : schedule) {

                        sb.append("T")
                          .append(transactionId)
                          .append(" ");
                    }

                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }
}