package com.studyplanner.strategy;

import java.util.List;
import java.util.Map;

public interface StudyPlanStrategy {
    Map<String, Double> generatePlan(List<String> topics, int timeAvailable);
    Map<String, Double> distributeTime(List<String> topics, Map<String, Double> aiPlan, double timeAvailable);
}
