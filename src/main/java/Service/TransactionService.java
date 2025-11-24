package service;

import model.Transaction;
import java.util.List;

/**
 * Service class for categorizing transactions using simple rules.
 */
public class TransactionService {

    /**
     * Categorizes transactions based on keywords in the description.
     */
    public void categorizeAllTransactions(List<Transaction> transactions) {
        for (Transaction t : transactions) {
            String desc = t.getDescription().toLowerCase();
            if (desc.contains("walmart") || desc.contains("grocery") || desc.contains("supermarket")) {
                t.setCategory("Groceries");
            } else if (desc.contains("uber") || desc.contains("lyft") || desc.contains("taxi")) {
                t.setCategory("Travel");
            } else if (desc.contains("netflix") || desc.contains("spotify") || desc.contains("movie")) {
                t.setCategory("Entertainment");
            } else if (desc.contains("restaurant") || desc.contains("dinner") || desc.contains("cafe") || desc.contains("mcdonalds")) {
                t.setCategory("Dining Out");
            } else if (desc.contains("shopping") || desc.contains("mall") || desc.contains("amazon")) {
                t.setCategory("Shopping");
            } else {
                t.setCategory("Ambiguous");
            }
        }
    }
}
