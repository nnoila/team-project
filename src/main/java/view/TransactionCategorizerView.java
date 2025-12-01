package view;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entity.SpendingSummary;
import entity.Transaction;
import interface_adapter.categorizer.CategorizerController;
import interface_adapter.categorizer.CategorizerViewModel;
import use_case.ai_insights.TrendAnalyzer;

public class TransactionCategorizerView extends JPanel implements PropertyChangeListener {

    private final String viewName = "categorizer view";

    private final JTextArea resultsArea = new JTextArea();
    private final JButton categorizeButton = new JButton("Categorize Transactions");
    private final JButton insightButton = new JButton("Generate Insights");
    private final JButton viewReportButton = new JButton("View Report");

    private final CategorizerViewModel vm;
    private CategorizerController categorizerController;

    public TransactionCategorizerView(CategorizerViewModel vm) {
        this.vm = vm;
        setLayout(new BorderLayout());
        resultsArea.setEditable(false);
        vm.addPropertyChangeListener(this);
        JPanel topPanel = new JPanel();
        topPanel.add(categorizeButton);
        topPanel.add(viewReportButton);
        topPanel.add(insightButton);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        categorizeButton.addActionListener(e ->
                categorizerController.categorizeTransactions(vm.getTransactions()));
        insightButton.addActionListener(e -> generateInsights());
        viewReportButton.addActionListener(e -> {
            categorizerController.goToSpendingReport(vm.getTransactions().get(0).getUsername());
        });
    }

    private void generateInsights() {
        if (vm.getTransactions() == null || vm.getTransactions().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Categorize transactions first.");
            return;
        }

        TrendAnalyzer analyzer = new TrendAnalyzer();
        SpendingSummary summary = analyzer.analyze(vm.getTransactions());

        new InsightView(summary);
    }

    public String getViewName() { return viewName; }

    public void setCategorizerController(CategorizerController categorizerController) {
        this.categorizerController = categorizerController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        StringBuilder sb = new StringBuilder("Categorized Transactions:\n\n");
        CategorizerViewModel viewModel = (CategorizerViewModel) evt.getSource();
        for (Transaction t : viewModel.getTransactions()) {
            sb.append(t.getDate())
                    .append(" | ")
                    .append(t.getMerchant())
                    .append(" | $")
                    .append(t.getAmount())
                    .append(" | Category: ")
                    .append(t.getCategory().toUpperCase())
                    .append("\n");
        }
        resultsArea.setText(sb.toString());
    }

}
