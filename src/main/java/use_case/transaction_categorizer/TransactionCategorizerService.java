package use_case.transaction_categorizer;

import entity.Transaction;
import use_case.ai_client.GeminiClient;

import java.util.List;

public class TransactionCategorizerService {

    private final GeminiClient gemini;

    public TransactionCategorizerService(GeminiClient gemini) {
        this.gemini = gemini;
    }

    public void categorizeTransactions(List<Transaction> transactions) {
        for (Transaction t : transactions) {
            String prompt = TransactionPromptBuilder.buildPrompt(t);
            String category = gemini.generateInsight(prompt).trim();
            t.setCategory(category);
        }
    }
}
