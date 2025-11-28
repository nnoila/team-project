package interface_adapter.spending_limits;

import use_case.spending_limits.SpendingLimitsInputBoundary;

public class SpendingLimitsController {
    private final SpendingLimitsInputBoundary interactor;

    public SpendingLimitsController(SpendingLimitsInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void goToSpendingLimits() {
        interactor.execute();
    }
}
