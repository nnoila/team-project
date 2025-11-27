package data_access;
import entity.Transaction;
import java.util.List;
public interface TransactionDsGateway {
    void save(Transaction transaction);

    void saveAll(List<Transaction> transactions);

    List<Transaction> getTransactionsByCategory(String category);

    double getTotalSpendByCategory(String category);
}
