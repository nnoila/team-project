package interface_adapter;

import entity.Transaction;
import java.util.List;

public class CategorizerViewModel {
    private List<Transaction> transactions;

    public void setTransactions(List<Transaction> t) { this.transactions = t; }
    public List<Transaction> getTransactions() { return transactions; }
}
