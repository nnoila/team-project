package use_case.spending_limits;

public interface SpendingLimitsOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
