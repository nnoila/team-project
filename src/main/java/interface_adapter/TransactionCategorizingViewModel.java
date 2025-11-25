package interface_adapter;

import entity.Transaction;

import java.util.List;

public class TransactionCategorizingViewModel {

    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
