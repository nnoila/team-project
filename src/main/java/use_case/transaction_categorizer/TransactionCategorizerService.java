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

        StringBuilder batchPrompt = new StringBuilder("""
                You are a classification engine.
                
                Categorize each transaction into EXACTLY one of the following categories:
                SHOPPING, DINING OUT, ENTERTAINMENT, UTILITIES, TRANSPORTATION, FITNESS, MISCELLANEOUS.
                
                IMPORTANT:
                - Respond ONLY with VALID JSON.
                - NO explanations, no comments.
                - DO NOT add extra text.
                - Format MUST be:
                
                [
                  {"description": "...", "category": "SHOPPING"},
                  {"description": "...", "category": "DINING OUT"}
                ]
                
                Here are the transactions:
                """);

        for (Transaction t : transactions) {
            batchPrompt.append("- ").append(t.getDescription())
                    .append(" ($").append(t.getAmount()).append(")\n");
        }

        // 2) Make ONE call to Gemini
        String response = client.askGemini(batchPrompt.toString());

        System.out.println("\n===== RAW BATCH RESPONSE =====\n" + response + "\n========================\n");

        try {
            response = response.replace("```json", "")
                    .replace("```", "")
                    .trim();

            String jsonOnly = response.replaceAll("(?s).*?(\\[.*\\]).*", "$1");

            JSONArray jsonArray = new JSONArray(jsonOnly);

            for (int i = 0; i < transactions.size() && i < jsonArray.length(); i++) {
                String category = jsonArray.getJSONObject(i)
                        .optString("category", "MISCELLANEOUS")
                        .trim()
                        .toUpperCase()
                        .replaceAll("[^A-Z ]", ""); // clean symbols

                category = normalizeCategory(category);
                category = category.toUpperCase();

                if (!TransactionPromptBuilder.isValid(category)) {
                    category = "MISCELLANEOUS";
                }

                transactions.get(i).setCategory(category);
            }

        } catch (Exception e) {
            System.err.println("Failed to parse batch — applying fallback");
            transactions.forEach(t -> t.setCategory("MISCELLANEOUS"));

        }

    }
    private String normalizeCategory(String raw) {

        raw = raw.toLowerCase();

        return switch (raw) {
            case "food", "takeout", "restaurant", "eat out" -> "DINING OUT";
            case "shopping", "clothes", "electronics" -> "SHOPPING";
            case "transport", "taxi", "uber", "bus", "car" -> "TRANSPORTATION";
            case "entertainment", "movies", "concert", "streaming" -> "ENTERTAINMENT";
            case "utilities", "internet", "phone", "electricity" -> "UTILITIES";
            default -> raw;
        };
    }

}
