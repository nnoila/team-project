package use_case.filter_search;

import entity.Transaction;
import java.util.List;

/**
 * Output data for the Filter & Search Transactions use case.
 * Contains the filtered list of transactions and a status message
 * for the presenter to display.
 */
public class FilterSearchOutputData {

    private final List<Transaction> filteredTransactions;

    private final String message;

    public FilterSearchOutputData(List<Transaction> filteredTransactions, String message) {
        this.filteredTransactions = filteredTransactions;
        this.message = message;
    }

    public List<Transaction> getFilteredTransactions() {
        return filteredTransactions;
    }

    public String getMessage() {
        return message;
    }
}
