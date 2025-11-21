package use_case.filter_search;

public interface FilterSearchOutputBoundary {

    /**
     * results of the filter search use case.
     *
     * @param outputData data w matched items and message.
     */
    void present(FilterSearchOutputData outputData);
}

