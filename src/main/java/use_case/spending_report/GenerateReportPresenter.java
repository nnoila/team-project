package use_case.spending_report;
import interface_adapter.ViewManagerModel;
import view.SpendingReportView;
import view.ViewManager;

public class GenerateReportPresenter implements GenerateReportOutputBoundary {
    private SpendingReportView view;
    private ViewManagerModel viewManagerModel;

    public GenerateReportPresenter(SpendingReportView view, ViewManagerModel viewManagerModel) {
        this.view = view;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentReport(GenerateReportOutput outputData) {
        if (outputData.isSuccess()) {
            view.displayChart(outputData.getReport().getCategoryBreakdown()
            );
        } else {
            view.displayChart(null);
        }
    }

    @Override
    public void backToCategorizeView() {
        this.viewManagerModel.setState("categorizer view");
        this.viewManagerModel.firePropertyChange();
    }

}