package com.studyplanner.strategy;

import java.util.List;
import java.util.Map;

public interface StudyPlanStrategy {
    Map<String, Double> generatePlan(List<String> topics, int timeAvailable);
}
