package interface_adapter.filter_search;

import use_case.filter_search.FilterSearchInputBoundary;
import use_case.filter_search.FilterSearchInputData;

import java.time.LocalDate;

public class FilterSearchController {

    private final FilterSearchInputBoundary interactor;

    public FilterSearchController(FilterSearchInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void runSearch(String category,
                          String startDateStr,
                          String endDateStr,
                          String keyword) {

        LocalDate start = (startDateStr == null || startDateStr.isEmpty())
                ? null
                : LocalDate.parse(startDateStr);

        LocalDate end = (endDateStr == null || endDateStr.isEmpty())
                ? null
                : LocalDate.parse(endDateStr);

        FilterSearchInputData data =
                new FilterSearchInputData(category, start, end, keyword);

        interactor.execute(data);
    }
}
