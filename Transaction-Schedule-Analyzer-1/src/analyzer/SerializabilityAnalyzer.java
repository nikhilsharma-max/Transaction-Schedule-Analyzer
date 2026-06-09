package analyzer;

import graph.AllTopologicalSorts;
import graph.CycleDetector;
import graph.Graph;
import graph.PrecedenceGraphBuilder;
import java.util.ArrayList;
import java.util.List;
import models.AnalysisResult;
import models.Conflict;
import models.Operation;
import parser.ScheduleParser;

public class SerializabilityAnalyzer {

    private ScheduleParser parser;
    private ConflictDetector conflictDetector;
    private PrecedenceGraphBuilder graphBuilder;
    private CycleDetector cycleDetector;
    private AllTopologicalSorts allTopologicalSorts;

    public SerializabilityAnalyzer() {

        parser = new ScheduleParser();

        conflictDetector = new ConflictDetector();

        graphBuilder = new PrecedenceGraphBuilder();

        cycleDetector = new CycleDetector();

        allTopologicalSorts = new AllTopologicalSorts();
    }

    public AnalysisResult analyze(String schedule) {

        List<Operation> operations =
                parser.parse(schedule);

        List<Conflict> conflicts =
                conflictDetector.detectConflicts(operations);

        Graph graph =
                graphBuilder.buildGraph(
                        operations,
                        conflicts
                );

        boolean hasCycle =
                cycleDetector.hasCycle(graph);

        List<List<Integer>> serialSchedules =
                new ArrayList<>();

        if (!hasCycle) {

            serialSchedules =
                    allTopologicalSorts
                            .getAllTopologicalOrders(graph);
        }

        return new AnalysisResult(
                !hasCycle,
                conflicts,
                graph,
                serialSchedules
        );
    }
}