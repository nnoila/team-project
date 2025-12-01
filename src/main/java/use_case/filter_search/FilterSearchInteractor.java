package use_case.filter_search;

import data_access.CSVTransactionDAO;
import entity.Transaction;

import java.util.List;

public class FilterSearchInteractor implements FilterSearchInputBoundary {

    private final CSVTransactionDAO transactionDAO;
    private final FilterSearchOutputBoundary presenter;

    public FilterSearchInteractor(CSVTransactionDAO transactionDAO,
                                  FilterSearchOutputBoundary presenter) {
        this.transactionDAO = transactionDAO;
        this.presenter = presenter;
    }

    @Override
    public void execute(FilterSearchInputData input) {

        List<Transaction> all = transactionDAO.getAllTransactions();

        List<Transaction> filtered = all.stream()
                .filter(t -> input.getCategory() == null ||
                        t.getCategory().equalsIgnoreCase(input.getCategory()))
                .filter(t -> input.getStartDate() == null ||
                        !t.getDate().isBefore(input.getStartDate()))
                .filter(t -> input.getEndDate() == null ||
                        !t.getDate().isAfter(input.getEndDate()))
                .filter(t -> input.getKeyword() == null ||
                        t.getMerchant().toLowerCase().contains(input.getKeyword().toLowerCase()))
                .toList();

        presenter.present(new FilterSearchOutputData(filtered));
    }
}
