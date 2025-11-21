package use_case.filter_search;

import java.util.List;

public class FilterSearchInteractor implements FilterSearchInputBoundary {

    private final FilterSearchUserDataAccessInterface userDataAccess;
    private final FilterSearchOutputBoundary presenter;

    public FilterSearchInteractor(FilterSearchUserDataAccessInterface userDataAccess,
                                  FilterSearchOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(FilterSearchInputData inputData) {

        // Step 1: Ask the database/data layer for matching users
        List<String> results = userDataAccess.filterUsers(
                inputData.getStartDate(),
                inputData.getEndDate(),
                inputData.getCategory(),
                inputData.getKeyword(),
                inputData.getUserId()
        );

        // Step 2: Build the output data
        String msg = results.size() + " results found";
        FilterSearchOutputData outputData = new FilterSearchOutputData(results, msg);

        // Step 3: Give it to the presenter
        presenter.prepareSuccessView(outputData);
    }
}
