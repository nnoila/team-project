package app;

import use_case.ai_insights.GeminiClient;
import use_case.ai_insights.InsightService;
import entity.SpendingSummary;
import controller.InsightsController;
import use_case.ai_insights.presenter.InsightPresenter;
import view.InsightViewModel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class InsightApp extends Application {

    @Override
    public void start(Stage stage) {

        Label resultLabel = new Label("Press the button to generate insights on your spending pattern.");
        resultLabel.setWrapText(true);
        Label spendingSummaryLabel = new Label();
        spendingSummaryLabel.setWrapText(true);

        Button generateButton = new Button("Generate AI Insight");

        InsightViewModel vm = new InsightViewModel();
        InsightPresenter presenter = new InsightPresenter(vm);
        InsightService interactor = new InsightService(new GeminiClient());
        InsightsController controller = new InsightsController(interactor, presenter);

        // temp spending data
        SpendingSummary summary = new SpendingSummary(
                560.75,
                Map.of(
                        "Dining", 210.50,
                        "Groceries", 320.25,
                        "Shopping", 30.00
                ),
                "Groceries"
        );

        presenter.presentSummary(summary);
        spendingSummaryLabel.setText(vm.getSpendingBreakdown());

        generateButton.setOnAction(event -> {
            controller.generateInsight(summary, "demoUser");

            resultLabel.setText(vm.getSummary() + "\n\nTips:\n" +
                            vm.getRecommendations() + "\n\n" +
                            vm.getDate()
            );
        });

        VBox layout = new VBox(15, spendingSummaryLabel, generateButton, resultLabel);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene);
        stage.setTitle("AI Spending Insights");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
