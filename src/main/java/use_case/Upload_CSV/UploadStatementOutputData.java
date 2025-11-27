package use_case.Upload_CSV;

import java.util.Map;
import java.util.List;

public class UploadStatementOutputData {

    private final int numTransactionsImported;
    private final boolean success;
    private final String message;

    private final Map<String, Double> categoryTotals;
    private final List<String> alerts;

    public UploadStatementOutputData(
            int numTransactionsImported,
            boolean success,
            String message,
            Map<String, Double> categoryTotals,
            List<String> alerts
    ) {
        this.numTransactionsImported = numTransactionsImported;
        this.success = success;
        this.message = message;
        this.categoryTotals = categoryTotals;
        this.alerts = alerts;
    }

    public int getNumTransactionsImported() { return numTransactionsImported; }
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Map<String, Double> getCategoryTotals() { return categoryTotals; }
    public List<String> getAlerts() { return alerts; }
}