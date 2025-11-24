import model.Transaction;
import service.TransactionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo for Use Case 2: rule-based transaction categorization.
 */
public class Main {
    public static void main(String[] args) {
        TransactionService service = new TransactionService();

        // Sample transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 10, "Dinner at McDonalds", 15.50));
        transactions.add(new Transaction(2, 10, "Uber ride downtown", 12.30));
        transactions.add(new Transaction(3, 10, "Groceries from Walmart", 78.00));
        transactions.add(new Transaction(4, 10, "Spotify subscription", 10.99));
        transactions.add(new Transaction(5, 10, "Random store purchase", 25.00));

        // Categorize all transactions
        service.categorizeAllTransactions(transactions);

        // Print results
        for (Transaction t : transactions) {
            System.out.println(t.getDescription() + " -> " + t.getCategory());
        }
    }
}
