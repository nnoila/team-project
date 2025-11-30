package use_case.ai_insights;
import entity.Insight;
import use_case.transaction_categorizer.GeminiClient;
import entity.SpendingSummary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class InsightPresenter {

    private final InsightViewModel viewModel;

    public InsightPresenter(InsightViewModel vm) {
        this.viewModel = vm;
    }

    public void presentSummary(SpendingSummary summary) {
         String breakdown = summary.totals().entrySet().stream()
             .map(entry -> entry.getKey() + ": $" + entry.getValue())
             .reduce("", (a, b) -> a + b + "\n")
             .trim();

         viewModel.setSpendingBreakdown(
             "Total Spent: $" + summary.totalSpent() + "\n\n" +
             "Breakdown:\n" + breakdown + "\n\n" +
             "Highest Category: " + summary.highestCategory()
            );
        }

    public void present(Insight insight, SpendingSummary summary) {

        viewModel.setSummary(insight.getSummaryText());
            if (insight.getRecommendations() == null) {
                 viewModel.setRecommendations("No recommendations available.");
            } else {
                String formatted = "• " + String.join("\n• ", insight.getRecommendations());
                viewModel.setRecommendations(formatted);
            }


            // Timestamp
            viewModel.setDate("Generated: " + insight.getGeneratedAt());
        }
    }


