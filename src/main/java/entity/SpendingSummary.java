package entity;

import java.util.List;
import java.util.Map;

public record SpendingSummary(
        double totalSpent,
        Map<String, Double> totals,
        String highestCategory,
        List<SpendingLimit> spendingLimits
) {}

