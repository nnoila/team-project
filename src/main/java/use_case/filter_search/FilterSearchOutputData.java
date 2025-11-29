package use_case.filter_search;

import java.util.List;

public class FilterSearchOutputData {

    private final List<String> results;

    public FilterSearchOutputData(List<String> results) {
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }
}