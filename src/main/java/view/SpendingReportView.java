package view;

import use_case.spending_report.ChartVisualizer;
import use_case.spending_report.GenerateReportController;
import use_case.spending_report.SpendingReportViewModel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

public class SpendingReportView extends JPanel {
    private final JComboBox<String> chartTypeDropdown;
    private final JPanel chartPanelContainer;
    private final String viewName = "spending report";
    private GenerateReportController controller;
    private final SpendingReportViewModel viewModel;
    private final JButton backButton;

    public void setGenerateReportController(GenerateReportController controller) {
        this.controller = controller;
    }

    public SpendingReportView(SpendingReportViewModel viewModel) {
        this.viewModel = viewModel;
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        chartTypeDropdown = new JComboBox<>(new String[]{
            "Bar Chart", "Pie Chart"
        });

        topPanel.add(new JLabel("Chart Type:"));
        topPanel.add(chartTypeDropdown);
        backButton = new JButton("Back");
        topPanel.add(backButton);
        add(topPanel, BorderLayout.NORTH);

        chartPanelContainer = new JPanel(new BorderLayout());
        add(chartPanelContainer, BorderLayout.CENTER);
        backButton.addActionListener(e-> {
            controller.backToCategorizeView();
        });

        // Wire UI listeners on the SpendingReportView to call the controller
        this.addChartTypeDropdownListener(e -> {
            String chartType = (String) this.getChartTypeDropdown().getSelectedItem();
            viewModel.setChartType(chartType);
            controller.generateReport(viewModel.getState().getUsername());
        });
    }

    public JComboBox<String> getChartTypeDropdown() { return chartTypeDropdown; }
    public JPanel getChartPanelContainer() { return chartPanelContainer; }
    public String getViewName() { return viewName; }



    public void addChartTypeDropdownListener(ActionListener listener) {
        chartTypeDropdown.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void displayChart(Map<String, Float> categoryData) {
        if (categoryData == null || categoryData.isEmpty()) {
            chartPanelContainer.removeAll();
            chartPanelContainer.revalidate();
            chartPanelContainer.repaint();
            // JOptionPane.showMessageDialog(this, "No transactions found for this month.");
            return;
        }
        chartPanelContainer.removeAll();
        String type = (String) chartTypeDropdown.getSelectedItem();

        JPanel chartPanel = ChartVisualizer.createChart(categoryData, type);
        chartPanelContainer.add(chartPanel, BorderLayout.CENTER);

        chartPanelContainer.revalidate();
        chartPanelContainer.repaint();
    }

}
