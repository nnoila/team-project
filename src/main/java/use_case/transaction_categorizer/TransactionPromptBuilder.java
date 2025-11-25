package use_case.transaction_categorizer;

import entity.Transaction;

public class TransactionPromptBuilder {

    public static String buildPrompt(Transaction transaction) {
        return "Please categorize this transaction:\n"
                + "Description: " + transaction.getDescription() + "\n"
                + "Amount: $" + transaction.getAmount();
    }
}
