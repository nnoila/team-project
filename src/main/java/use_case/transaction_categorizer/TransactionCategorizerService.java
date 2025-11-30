package use_case.transaction_categorizer;

import entity.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class TransactionCategorizerService {

    private final GeminiClient client;

    public TransactionCategorizerService(GeminiClient client) {
        this.client = client;
    }

    public void categorize(List<Transaction> transactions) {

        for (Transaction t : transactions) {
            String prompt = TransactionPromptBuilder.buildPrompt(t);

            String response = client.askGemini(prompt);

            // if missing key → default
            if (response.equals("ERROR_NO_KEY")) {
                t.setCategory("MISCELLANEOUS");
                continue;
            }

            try {
                JSONObject json = new JSONObject(response);
                JSONArray parts = json
                        .getJSONArray("candidates")
                        .getJSONObject(0)
                        .getJSONObject("content")
                        .getJSONArray("parts");

                String aiCategory = parts.getJSONObject(0).getString("text").trim();

                t.setCategory(aiCategory.toUpperCase());

            } catch (Exception e) {
                t.setCategory("MISCELLANEOUS");
            }
        }
    }
}
