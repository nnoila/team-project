package use_case.filter_search;

/**
 * Input data for the Filter & Search Transactions use case.
 * This object carries the raw data provided by the user (via the Controller)
 * to the Interactor.
 */
public class FilterSearchInputData {

    private final String userId;
    private final String startDate;
    private final String endDate;
    private final String category;
    private final String keyword;

    public FilterSearchInputData(String userId,
                                 String startDate,
                                 String endDate,
                                 String category,
                                 String keyword) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.keyword = keyword;
    }

    public String getUserId() {
        return userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public String getKeyword() {
        return keyword;
    }
}
