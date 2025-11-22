package ui;

import ai_insights.GeminiClient;
import ai_insights.InsightService;
import ai_insights.SpendingSummary;
import entity.Insight;
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

        Label resultLabel = new Label("Press the button to generate insights.");
        Button generateButton = new Button("Generate AI Insight");

        generateButton.setOnAction(event -> {
            try {
                // temporary mock data — replace later
                SpendingSummary summary = new SpendingSummary(
                        560.75,
                        Map.of(
                                "Dining", 210.50,
                                "Groceries", 320.25,
                                "Shopping", 30.00
                        ),
                        "Groceries"
                );

                InsightService service = new InsightService(new GeminiClient());
                Insight insight = service.generateInsights(summary, "demoUser");

                // display results in UI
                resultLabel.setText(
                        "Summary:\n" + insight.getSummaryText() +
                         "\n\nTips:\n" + String.join("\n", insight.getRecommendations())
                );

            } catch (Exception e) {
                resultLabel.setText("Error: " + e.getMessage());
            }
        });

        VBox layout = new VBox(15, generateButton, resultLabel);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 500, 400);
        stage.setScene(scene);
        stage.setTitle("AI Budget Insights");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
