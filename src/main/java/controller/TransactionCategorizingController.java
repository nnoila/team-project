package controller;

import entity.Transaction;
import interface_adapter.TransactionCategorizingViewModel;
import use_case.ai_categorizing.TransactionCategorizingService;

import java.util.List;

public class TransactionCategorizingController {

    private final TransactionCategorizingService service;
    private final TransactionCategorizingViewModel viewModel;

    public TransactionCategorizingController(TransactionCategorizingService service,
                                             TransactionCategorizingViewModel viewModel) {
        this.service = service;
        this.viewModel = viewModel;
    }

    public void categorizeTransactions(List<Transaction> transactions) {
        service.categorize(transactions);
        viewModel.setTransactions(transactions);
    }
}
