package use_case.ai_insights;
import entity.Insight;
import use_case.transaction_categorizer.GeminiClient;
import interface_adapter.InsightViewModel;
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
        StringBuilder breakdown = new StringBuilder("Spending Breakdown:\n");

        for (Map.Entry<String, Double> entry : summary.totals().entrySet()) {
            breakdown.append(entry.getKey())
                    .append(": $")
                    .append(String.format("%.2f", entry.getValue()))
                    .append("\n");
        }

        viewModel.setSpendingBreakdown(breakdown.toString());
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


