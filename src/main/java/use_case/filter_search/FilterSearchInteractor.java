package use_case.filter_search;

import entity.Transaction;
import java.util.List;

public class FilterSearchInteractor implements FilterSearchInputBoundary {

    private final FilterSearchUserDataAccessInterface transactionDataAccess;
    private final FilterSearchOutputBoundary presenter;

    public FilterSearchInteractor(FilterSearchUserDataAccessInterface transactionDataAccess,
                                  FilterSearchOutputBoundary presenter) {
        this.transactionDataAccess = transactionDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(FilterSearchInputData inputData) {

        // Step 1: Ask DAO to filter based on criteria
        List<Transaction> results = transactionDataAccess.filterTransactions(
                inputData.getStartDate(),
                inputData.getEndDate(),
                inputData.getCategory(),
                inputData.getKeyword(),
                inputData.getUserId()
        );

        // Step 2: Build output message
        String message;
        if (results.isEmpty()) {
            message = "No matching transactions found.";
        } else {
            message = results.size() + " matching transactions found.";
        }

        // Step 3: Construct output data
        FilterSearchOutputData outputData = new FilterSearchOutputData(results, message);

        // Step 4: Send results to presenter
        presenter.prepareSuccessView(outputData);
    }
}
