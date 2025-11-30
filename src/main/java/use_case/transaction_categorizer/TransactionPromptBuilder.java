package use_case.transaction_categorizer;

import entity.Transaction;

public class TransactionPromptBuilder {

    private static final String FIXED_CATEGORIES =
            "SHOPPING, DINING OUT, ENTERTAINMENT, UTILITIES, MISCELLANEOUS, FITNESS, TRANSPORTATION";

    public static String buildPrompt(Transaction t) {
        return """
                Categorize the following bank transaction into EXACTLY ONE of these categories:
                %s

                Respond ONLY with the category name. No explanation.

                Description: %s
                Amount: %.2f
                """
                .formatted(
                        FIXED_CATEGORIES,
                        t.getDescription(),
                        t.getAmount()
                );
    }
}
