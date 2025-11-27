package data_access;
import entity.Transaction;
import java.util.List;
import java.util.ArrayList;
public class TransactionDataAccessObject {
    private final List<Transaction> transactions = new ArrayList<>();

    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public void clearAllTransactions() {
        transactions.clear();
    }


}
