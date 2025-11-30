package view;

import use_case.spending_report.ChartVisualizer;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SpendingReportView extends JPanel {
    private final JComboBox<String> chartTypeDropdown;
    private final JPanel chartPanelContainer;
    private final String viewName = "spending report";

    public SpendingReportView() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        chartTypeDropdown = new JComboBox<>(new String[]{
            "Bar Chart", "Pie Chart"
        });

        topPanel.add(new JLabel("Chart Type:"));
        topPanel.add(chartTypeDropdown);
        add(topPanel, BorderLayout.NORTH);

        chartPanelContainer = new JPanel(new BorderLayout());
        add(chartPanelContainer, BorderLayout.CENTER);
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
            JOptionPane.showMessageDialog(this, "No transactions found for this month.");
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
