package app;

import analyzer.SerializabilityAnalyzer;
import models.AnalysisResult;

public class Main {

    public static void main(String[] args) {

        String schedule =
                "R1(X) W2(X) R3(Y) W1(Y) W2(Y) R3(X)";

        SerializabilityAnalyzer analyzer =
                new SerializabilityAnalyzer();

        AnalysisResult result =
                analyzer.analyze(schedule);

        System.out.println(result);
    }
}