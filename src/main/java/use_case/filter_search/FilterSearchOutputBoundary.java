package use_case.filter_search;

public interface FilterSearchOutputBoundary {

    /**
     * @param outputData the data containing the filtered list of transactions
     */
    void prepareSuccessView(FilterSearchOutputData outputData);

    /**
     * @param errorMessage a message describing what went wrong
     */
    void prepareFailView(String errorMessage);
}
