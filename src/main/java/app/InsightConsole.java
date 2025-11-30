package app;

import use_case.ai_insights.InsightClient;
import use_case.ai_insights.InsightService;
import entity.Insight;
import entity.SpendingSummary;

import java.util.List;
import java.util.Map;

public class InsightConsole {

    public static void main(String[] args) {

        // Simulated data (because Use Case 7 allows placeholder if not implemented yet)
        SpendingSummary summary = new SpendingSummary(
                560.75,
                Map.of(
                        "Dining", 210.50,
                        "Groceries", 320.25,
                        "Shopping", 30.00
                ),
                "Groceries", List.of()
        );

        String userId = "naila";

        InsightService service = new InsightService(new InsightClient());
        Insight insight = service.generateInsights(summary, userId);

        System.out.println("\n========== AI SPENDING INSIGHTS ==========\n");

        System.out.println("Generated: " + insight.getGeneratedAt());
        System.out.println("User: " + insight.getUserId());

        System.out.println("\nSummary:");
        System.out.println(insight.getSummaryText());

        System.out.println("\nRecommendations:");
        for (String tip : insight.getRecommendations()) {
            System.out.println(" - " + tip);
        }

        System.out.println("\n==========================================");
    }
}

