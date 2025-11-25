package view;

import entity.Transaction;
import interface_adapter.CategorizerViewModel;
import use_case.ai_client.GeminiClient;
import use_case.transaction_categorizer.TransactionCategorizerService;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionCategorizerView extends Application {

    @Override
    public void start(Stage stage) {

        Label resultLabel = new Label("Press the button to categorize transactions.");
        resultLabel.setWrapText(true);

        Button categorizeButton = new Button("Categorize Transactions");

        CategorizerViewModel vm = new CategorizerViewModel();
        GeminiClient gemini = new GeminiClient();
        TransactionCategorizerService service = new TransactionCategorizerService(gemini);

        // Sample transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(LocalDate.now(), "Starbucks Coffee", 5.25, ""));
        transactions.add(new Transaction(LocalDate.now(), "Walmart Grocery", 120.50, ""));
        transactions.add(new Transaction(LocalDate.now(), "Uber Ride", 15.75, ""));

        categorizeButton.setOnAction(event -> {
            service.categorizeTransactions(transactions);
            vm.setCategorizedTransactions(transactions);

            StringBuilder sb = new StringBuilder("Categorized Transactions:\n\n");
            for (Transaction t : vm.getCategorizedTransactions()) {
                sb.append(t.getDateString())
                        .append(" - ")
                        .append(t.getDescription())
                        .append(" - $")
                        .append(t.getAmount())
                        .append(" - Category: ")
                        .append(t.getCategory())
                        .append("\n");
            }

            resultLabel.setText(sb.toString());
        });

        VBox layout = new VBox(15, categorizeButton, resultLabel);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Transaction Categorizer");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

