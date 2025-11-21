package ai_insights;

import java.util.Map;

public record SpendingSummary(
        double totalSpent,
        Map<String, Double> totals,
        String highestCategory
) {}

