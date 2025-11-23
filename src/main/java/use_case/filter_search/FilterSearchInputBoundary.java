package use_case.filter_search;

public interface FilterSearchInputBoundary {

    /**
     * @param inputData the user-selected filters (date range, category, keyword)
     */
    void execute(FilterSearchInputData inputData);
}
