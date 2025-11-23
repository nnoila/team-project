package use_case.filter_search;

import entity.Transaction;
import java.util.List;

public interface FilterSearchUserDataAccessInterface {

    /**
     * Returns all transactions that match the given filters.
     *
     * @param userId the user whose transactions we search
     * @param startDate the earliest date (inclusive), can be null
     * @param endDate the latest date (inclusive), can be null
     * @param category the spending category (can be null or empty)
     * @param keyword keyword that may appear in the transaction description (can be null or empty)
     * @return a List of matching Transaction entities
     */
    List<Transaction> filterTransactions(
            String userId,
            String startDate,
            String endDate,
            String category,
            String keyword
    );
}
