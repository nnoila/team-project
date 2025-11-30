package view;

import use_case.ai_insights.InsightClient;
import use_case.ai_insights.InsightService;
import entity.SpendingSummary;
import use_case.ai_insights.InsightsController;
import use_case.ai_insights.InsightPresenter;
import use_case.ai_insights.InsightViewModel;

import javax.swing.*;
import java.awt.*;

public class InsightView extends JFrame {

    public InsightView(SpendingSummary summary) {

        JLabel spendingSummaryLabel = new JLabel("<html>Loading summary...</html>");
        JLabel resultLabel = new JLabel("<html>Press the button to generate insights on your spending pattern.</html>");

        JButton generateButton = new JButton("Generate AI Insight");

        spendingSummaryLabel.setPreferredSize(new Dimension(550, 100));
        resultLabel.setPreferredSize(new Dimension(550, 250));

        spendingSummaryLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        InsightViewModel vm = new InsightViewModel();
        InsightPresenter presenter = new InsightPresenter(vm);
        InsightService interactor = new InsightService(new InsightClient());
        InsightsController controller = new InsightsController(interactor, presenter);

        presenter.presentSummary(summary);


        spendingSummaryLabel.setText("<html>" + vm.getSpendingBreakdown().replace("\n", "<br>") + "</html>");

        generateButton.addActionListener(e -> {
            controller.generateInsight(summary, "demoUser");
            String formattedOutput = "<html>" +
                    vm.getSummary().replace("\n", "<br>") +
                    "<br><br><b>Tips:</b><br>" +
                    vm.getRecommendations().replace("\n", "<br>") +
                    "<br><br>" + vm.getDate() +
                    "</html>";

            resultLabel.setText(formattedOutput);
        });

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(spendingSummaryLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(generateButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(resultLabel);

        setContentPane(panel);
        setTitle("AI Spending Insights");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
