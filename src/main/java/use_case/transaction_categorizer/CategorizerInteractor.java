package use_case.transaction_categorizer;

import entity.SpendingLimit;
import entity.Transaction;
import interface_adapter.categorizer.CategorizerViewModel;
import use_case.spending_limits.SpendingLimitsDataAccessInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategorizerInteractor implements CategorizerInputBoundary {

    private TransactionCategorizerService  categorizerService;
    private CategorizerOutputBoundary categorizerOutputBoundary;
    private SpendingLimitsDataAccessInterface spendingLimitsDataAccess;

    public CategorizerInteractor(TransactionCategorizerService categorizerService,
                                 CategorizerOutputBoundary categorizerOutputBoundary,
                                 SpendingLimitsDataAccessInterface spendingLimitsDataAccess) {
        this.categorizerService = categorizerService;
        this.categorizerOutputBoundary = categorizerOutputBoundary;
        this.spendingLimitsDataAccess = spendingLimitsDataAccess;
    }

    @Override
    public void generateCategories(List<Transaction> transactions) {
       categorizerService.categorize(transactions);
       categorizerOutputBoundary.displayCategorizationResults();
    }

    @Override
    public void goToSpendingReport(String username) {
        categorizerOutputBoundary.goToSpendingReport(username);
    }

    @Override
    public List<SpendingLimit> getSpendingLimits(String username) {
        List<SpendingLimit> results = new ArrayList<>();
        for (Map.Entry<String, Double> entry:
                spendingLimitsDataAccess.getSpendingLimitsByUsername(username).entrySet()) {
            results.add(new SpendingLimit(entry.getKey(), entry.getValue()));
        }
        return results;
    }

}
