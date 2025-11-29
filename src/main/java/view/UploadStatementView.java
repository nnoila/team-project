package view;

<<<<<<< Updated upstream
=======
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.upload_statement.UploadStatementController;
>>>>>>> Stashed changes
import interface_adapter.upload_statement.UploadStatementState;
import interface_adapter.upload_statement.UploadStatementViewModel;

public class UploadStatementView extends JPanel implements PropertyChangeListener {

    private final UploadStatementViewModel viewModel;
    private final JLabel totalLabel;
    private final String viewName = "statement view";

    public UploadStatementView(UploadStatementViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        this.add(new JLabel("Your total spend for this month: "));
        totalLabel = new JLabel("$0.00");
        this.add(totalLabel);
<<<<<<< Updated upstream
=======
        final JPanel buttons = new JPanel();
        analyzeStatementButton = new JButton("Analyze Statement");
        buttons.add(analyzeStatementButton);
        analyzeStatementButton.addActionListener(e ->
                this.uploadStatementController.goToSpendingReport()
        );
        setSpendingAlertsButton = new JButton("Set Spending Alerts");
        buttons.add(setSpendingAlertsButton);
        setSpendingAlertsButton.addActionListener(e ->
                this.uploadStatementController.goToSpendingLimits()
        );
        this.add(buttons);
>>>>>>> Stashed changes
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UploadStatementState state = (UploadStatementState) evt.getNewValue();
        totalLabel.setText(String.format("$%.2f", state.getTotalSpend()));
    }

    public String getViewName() {
        return viewName;
    }

}
