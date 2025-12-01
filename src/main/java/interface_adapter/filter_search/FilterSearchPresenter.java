package interface_adapter.filter_search;

import use_case.filter_search.FilterSearchOutputBoundary;
import use_case.filter_search.FilterSearchOutputData;

public class FilterSearchPresenter implements FilterSearchOutputBoundary {

    private final FilterSearchViewModel viewModel;

    public FilterSearchPresenter(FilterSearchViewModel vm) {
        this.viewModel = vm;
    }

    @Override
    public void present(FilterSearchOutputData data) {
        viewModel.setFiltered(data.getResults());
    }
}

