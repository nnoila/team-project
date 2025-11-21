package use_case.filter_search;

public interface FilterSearchInputBoundary {

    /**
     *
     *
     * @param inputData the request model containing filters
     *                  like date range, category, or keyword.
     */
    void execute(FilterSearchInputData inputData);
}
