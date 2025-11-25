package view;

import controller.TransactionCategorizingController;
import entity.Transaction;
import interface_adapter.TransactionCategorizingViewModel;
import use_case.ai_categorizing.TransactionCategorizingClient;
import use_case.ai_categorizing.TransactionCategorizingService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionCategorizingView extends Application {

    @Override
    public void start(Stage stage) {

        Label resultLabel = new Label("Press the button to categorize your transactions.");
        resultLabel.setWrapText(true);

        Button categorizeButton = new Button("Categorize Transactions");

        TransactionCategorizingViewModel vm = new TransactionCategorizingViewModel();
        TransactionCategorizingService service = new TransactionCategorizingService(new TransactionCategorizingClient());
        TransactionCategorizingController controller = new TransactionCategorizingController(service, vm);

        // Sample transactions
        List<Transaction> transactions = List.of(
                new Transaction("Starbucks", 5.50),
                new Transaction("Walmart", 120.00),
                new Transaction("Uber", 25.00)
        );

        categorizeButton.setOnAction(event -> {
            controller.categorizeTransactions(transactions);

            String output = vm.getTransactions().stream()
                    .map(t -> t.getDescription() + " - $" + t.getAmount() + " : " + t.getCategory())
                    .collect(Collectors.joining("\n"));

            resultLabel.setText(output);
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
