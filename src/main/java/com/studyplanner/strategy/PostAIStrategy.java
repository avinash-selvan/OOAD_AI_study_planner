package com.studyplanner.strategy;
import java.util.List;
import java.util.Map;

public interface PostAIStrategy {
    Map<String, Double> distributeTime(List<String> topics, Map<String, Double> aiPlan, double timeAvailable);
}
