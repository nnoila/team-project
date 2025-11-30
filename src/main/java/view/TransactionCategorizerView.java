package view;

import entity.Insight;
import entity.SpendingSummary;
import entity.Transaction;
import interface_adapter.CategorizerViewModel;
import use_case.ai_insights.InsightClient;
import use_case.ai_insights.InsightService;
import use_case.ai_insights.TrendAnalyzer;
import use_case.transaction_categorizer.TransactionCategorizerService;
import use_case.transaction_categorizer.GeminiClient;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionCategorizerView extends JPanel {

    private final String viewName = "categorizer view";

    private final JTextArea resultsArea = new JTextArea();
    private final JButton categorizeButton = new JButton("Categorize Transactions");
    private final JButton insightButton = new JButton("Generate Insights");

    private final CategorizerViewModel vm;
    private final TransactionCategorizerService service;
    private final List<Transaction> loadedTransactions;

    public TransactionCategorizerView(List<Transaction> transactions) {
        this.vm = new CategorizerViewModel();
        this.service = new TransactionCategorizerService(new GeminiClient());
        this.loadedTransactions = transactions;

        setLayout(new BorderLayout());
        resultsArea.setEditable(false);

        JPanel topPanel = new JPanel();
        topPanel.add(categorizeButton);
        topPanel.add(insightButton);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        categorizeButton.addActionListener(e -> runCategorizer());
        insightButton.addActionListener(e -> generateInsights());
    }

    private void runCategorizer() {
        vm.setTransactions(loadedTransactions);
        service.categorize(loadedTransactions);

        StringBuilder sb = new StringBuilder("Categorized Transactions:\n\n");
        for (Transaction t : loadedTransactions) {
            sb.append(t.getDate())
                    .append(" | ")
                    .append(t.getDescription())
                    .append(" | $")
                    .append(t.getAmount())
                    .append(" | Category: ")
                    .append(t.getCategory().toUpperCase())
                    .append("\n");
        }

        resultsArea.setText(sb.toString());
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
}






