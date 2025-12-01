package view;

import interface_adapter.filter_search.FilterSearchController;
import interface_adapter.filter_search.FilterSearchViewModel;

public class FilterSearchView {

    private FilterSearchController controller;
    private final FilterSearchViewModel viewModel;

    public FilterSearchView(FilterSearchViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setController(FilterSearchController controller) {
        this.controller = controller;
    }
}
