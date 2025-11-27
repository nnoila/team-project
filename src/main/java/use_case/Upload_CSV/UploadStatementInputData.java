package use_case.Upload_CSV;

public class UploadStatementInputData {
    private final String csvFilePath;
    public UploadStatementInputData(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }
    public String getCsvFilePath() {
        return csvFilePath;
    }
}

