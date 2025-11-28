package use_case.spending_limits;

public class SpendingLimitsInteractor implements SpendingLimitsInputBoundary {
    private final SpendingLimitsOutputBoundary presenter;

    public SpendingLimitsInteractor(SpendingLimitsOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {

    }
}
