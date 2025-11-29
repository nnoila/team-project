package use_case.filter_search;

import java.util.List;

public class FilterSearchInteractor implements FilterSearchInputBoundary {

    private final FilterSearchOutputBoundary presenter;
    private final FilterSearchUserDataAccessInterface userDataAccess;
    private final FilterSearchCategoryDataAccessInterface categoryDataAccess;

    public FilterSearchInteractor(FilterSearchOutputBoundary presenter,
                                  FilterSearchUserDataAccessInterface userDataAccess,
                                  FilterSearchCategoryDataAccessInterface categoryDataAccess) {
        this.presenter = presenter;
        this.userDataAccess = userDataAccess;
        this.categoryDataAccess = categoryDataAccess;
    }

    @Override
    public void execute(FilterSearchInputData inputData) {

        // 1. Validate input
        if (inputData.getSearchText() == null || inputData.getSearchText().isEmpty()) {
            presenter.presentError("Search text cannot be empty.");
            return;
        }

        // 2. Validate category (category may be OPTIONAL)
        String category = inputData.getCategory();

        if (category != null && !category.isEmpty() &&
                !categoryDataAccess.categoryExists(category)) {
            presenter.presentError("Invalid category: " + category);
            return;
        }

        // 3. Perform search
        List<String> results = userDataAccess.search(
                inputData.getSearchText(),
                category
        );

        // 4. Return results
        presenter.present(new FilterSearchOutputData(results));
    }
}
