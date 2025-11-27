package use_case.Upload_CSV;

import data_access.TransactionDsGateway;
import entity.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class UploadStatementInteractor implements UploadStatementInputBoundary {
    private final TransactionDsGateway transactionGateway;

    public UploadStatementInteractor(TransactionDsGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public void execute(UploadStatementInputData inputData) {

        String path = inputData.getCsvFilePath();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                LocalDate date = LocalDate.parse(values[0]);
                double amount = Double.parseDouble(values[2]);
                String category = values[3];

                Transaction transaction = new Transaction(date, amount, category);

                transactionGateway.save(transaction);
            }

        } catch (IOException e) {
            throw new RuntimeException("Invalid file or unable to read CSV");
        }
    }
}
