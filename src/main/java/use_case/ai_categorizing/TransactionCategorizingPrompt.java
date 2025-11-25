package use_case.ai_categorizing;

import entity.Transaction;

import java.util.List;

public class TransactionCategorizingPrompt {

    public static String buildPrompt(List<Transaction> transactions) {
        StringBuilder sb = new StringBuilder();
        sb.append("Categorize the following transactions into categories (e.g., Dining, Groceries, Transport, Shopping):\n");
        for (Transaction t : transactions) {
            sb.append("- ").append(t.getDescription()).append(": $").append(t.getAmount()).append("\n");
        }
        sb.append("\nReturn a JSON object mapping each description to a category.");
        return sb.toString();
    }
}
