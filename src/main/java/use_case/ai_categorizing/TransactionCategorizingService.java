package use_case.ai_categorizing;

import entity.Transaction;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class TransactionCategorizingService {

    private final TransactionCategorizingClient client;

    public TransactionCategorizingService(TransactionCategorizingClient client) {
        this.client = client;
    }

    public void categorize(List<Transaction> transactions) {
        String prompt = TransactionCategorizingPrompt.buildPrompt(transactions);
        String rawResponse = client.categorizeTransactions(prompt);

        rawResponse = rawResponse.replace("```json", "").replace("```", "").trim();

        JSONObject json = new JSONObject(rawResponse);

        for (Transaction t : transactions) {
            String category = json.optString(t.getDescription(), "Uncategorized");
            t.setCategory(category);
        }
    }
}
