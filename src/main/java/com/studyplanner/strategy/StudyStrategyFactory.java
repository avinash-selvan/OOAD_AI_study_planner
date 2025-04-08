package com.studyplanner.strategy;

public class StudyStrategyFactory {

    public static PostAIStrategy getStrategy(String strategyName) {
        switch (strategyName.toLowerCase()) {
            case "equal":
            case "equalbasedstrategy":
                return new EqualTimeStrategy();
            case "priority":
            case "prioritybasedstrategy":
                return new PriorityBasedStrategy();
            // case "spaced":
            //     return new SpacedRepetitionStrategy(); // later
            default:
                return new EqualTimeStrategy(); // fallback
        }
    }
}
