package interface_adapter.spending_limits;

import interface_adapter.ViewManagerModel;
import use_case.spending_limits.SpendingLimitsOutputBoundary;

public class SpendingLimitsPresenter implements SpendingLimitsOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SpendingLimitsViewModel spendingLimitsViewModel;

    public SpendingLimitsPresenter(ViewManagerModel viewManagerModel,
                                   SpendingLimitsViewModel viewModel) {
        this.viewManagerModel = viewManagerModel;
        this.spendingLimitsViewModel = viewModel;
    }

    @Override
    public void prepareSuccessView() {
        spendingLimitsViewModel.firePropertyChange();
        viewManagerModel.setState(spendingLimitsViewModel.getViewName());
        viewManagerModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
    }
}
