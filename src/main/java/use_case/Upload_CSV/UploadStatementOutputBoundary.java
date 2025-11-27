package use_case.Upload_CSV;

public interface UploadStatementOutputBoundary {
    void prepareSuccessView(UploadStatementOutputData outputData);
    void prepareFailView(String errorMessage);
}

