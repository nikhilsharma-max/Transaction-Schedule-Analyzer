package app;

import analyzer.SerializabilityAnalyzer;
import graph.Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import models.AnalysisResult;
import models.Conflict;

public class ApiMain {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("{\"error\":\"No schedule provided\"}");
            return;
        }

        String schedule = args[0];

        SerializabilityAnalyzer analyzer =
                new SerializabilityAnalyzer();

        AnalysisResult result =
                analyzer.analyze(schedule);

        StringBuilder json =
                new StringBuilder();

        json.append("{");

        // SERIALIZABLE

        json.append("\"serializable\":")
            .append(result.isSerializable())
            .append(",");

        // CONFLICTS

        json.append("\"conflicts\":[");

        List<Conflict> conflicts =
                result.getConflicts();

        for (int i = 0; i < conflicts.size(); i++) {

            json.append("\"")
                .append(conflicts.get(i).toString())
                .append("\"");

            if (i < conflicts.size() - 1) {
                json.append(",");
            }
        }

        json.append("],");

        // GRAPH

        Graph graph =
                result.getGraph();

        json.append("\"graph\":{");

        // NODES

        json.append("\"nodes\":[");

        List<Integer> vertices =
                new ArrayList<>(graph.getVertices());

        for (int i = 0; i < vertices.size(); i++) {

            json.append("{")
                .append("\"id\":\"T")
                .append(vertices.get(i))
                .append("\"")
                .append("}");

            if (i < vertices.size() - 1) {
                json.append(",");
            }
        }

        json.append("],");

        // EDGES

        json.append("\"edges\":[");

        boolean firstEdge = true;

        for (Integer source : graph.getVertices()) {

            Set<Integer> neighbors =
                    graph.getNeighbors(source);

            for (Integer target : neighbors) {

                if (!firstEdge) {
                    json.append(",");
                }

                json.append("{")
                    .append("\"source\":\"T")
                    .append(source)
                    .append("\",")
                    .append("\"target\":\"T")
                    .append(target)
                    .append("\"")
                    .append("}");

                firstEdge = false;
            }
        }

        json.append("]");

        json.append("},");

        // SERIAL SCHEDULES

        json.append("\"serialSchedules\":[");

        List<List<Integer>> schedules =
                result.getSerialSchedules();

        for (int i = 0; i < schedules.size(); i++) {

            List<Integer> serialSchedule =
                    schedules.get(i);

            json.append("[");

            for (int j = 0; j < serialSchedule.size(); j++) {

                json.append("\"T")
                    .append(serialSchedule.get(j))
                    .append("\"");

                if (j < serialSchedule.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            if (i < schedules.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        json.append("}");

        System.out.println(json);
    }
}