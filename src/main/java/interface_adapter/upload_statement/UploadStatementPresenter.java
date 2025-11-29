package interface_adapter.upload_statement;

import interface_adapter.ViewManagerModel;
<<<<<<< Updated upstream
=======
import interface_adapter.spending_limits.SpendingLimitsState;
import interface_adapter.spending_limits.SpendingLimitsViewModel;
import use_case.spending_report.SpendingReportViewModel;
>>>>>>> Stashed changes
import use_case.upload_statement.UploadStatementOutputBoundary;
import use_case.upload_statement.UploadStatementOutputData;

public class UploadStatementPresenter implements UploadStatementOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final UploadStatementViewModel uploadStatementViewModel;
<<<<<<< Updated upstream

    public UploadStatementPresenter(ViewManagerModel viewManagerModel,
                                    UploadStatementViewModel uploadStatementViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.uploadStatementViewModel = uploadStatementViewModel;
=======
    private final SpendingLimitsViewModel spendingLimitsViewModel;
    private final SpendingReportViewModel spendingReportViewModel;

    public UploadStatementPresenter(ViewManagerModel viewManagerModel,
                                    UploadStatementViewModel uploadStatementViewModel,
                                    SpendingLimitsViewModel spendingLimitsViewModel,
                                    SpendingReportViewModel spendingReportViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.uploadStatementViewModel = uploadStatementViewModel;
        this.spendingLimitsViewModel = spendingLimitsViewModel;
        this.spendingReportViewModel = spendingReportViewModel;
>>>>>>> Stashed changes
    }

    @Override
    public void prepareSuccessView(UploadStatementOutputData outputData) {
        final UploadStatementState state = this.uploadStatementViewModel.getState();
        state.setTotalSpend(outputData.getTotalSpend());

        this.uploadStatementViewModel.firePropertyChange();

        // Switch to UploadStatementView
        this.viewManagerModel.setState(uploadStatementViewModel.getViewName());
        this.viewManagerModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void prepareSpendingReportView() {
        this.viewManagerModel.setState(spendingReportViewModel.getViewName());
        this.viewManagerModel.firePropertyChange();
    }
}
