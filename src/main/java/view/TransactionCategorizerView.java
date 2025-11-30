package view;

import entity.Transaction;
import interface_adapter.CategorizerViewModel;
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

    private final CategorizerViewModel vm;
    private final TransactionCategorizerService service;

    public TransactionCategorizerView() {

        this.vm = new CategorizerViewModel();
        this.service = new TransactionCategorizerService(new GeminiClient());

        setLayout(new BorderLayout());
        resultsArea.setEditable(false);

        add(categorizeButton, BorderLayout.NORTH);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        categorizeButton.addActionListener(e -> runCategorizer());
    }

    private void runCategorizer() {

        List<Transaction> transactions = loadDummyData();
        vm.setTransactions(transactions);

        service.categorize(transactions);

        StringBuilder sb = new StringBuilder("Categorized Transactions:\n\n");
        for (Transaction t : transactions) {
            sb.append(t.getDate())
                    .append(" | ")
                    .append(t.getDescription())
                    .append(" | $")
                    .append(t.getAmount())
                    .append(" | Category: ")
                    .append(t.getCategory())
                    .append("\n");
        }

        resultsArea.setText(sb.toString());
    }

    private List<Transaction> loadDummyData() {
        List<Transaction> list = new ArrayList<>();
        String category;
        list.add(new Transaction(LocalDate.of(2024, 11, 12), category, 12.50, "Starbucks Coffee"));
        list.add(new Transaction(LocalDate.of(2024, 11, 13), category, 120.00, "Nike Clothing Store"));
        list.add(new Transaction(LocalDate.of(2024, 11, 14), category, 45.00, "Uber Ride"));
        return list;
    }

    public String getViewName() { return viewName; }
}
