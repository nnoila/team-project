package use_case.filter_search;

public class FilterSearchInputData {

    private final String startDate;
    private final String endDate;
    private final String category;
    private final String keyword;
    private final String userId;

    public FilterSearchInputData(String startDate,
                                 String endDate,
                                 String category,
                                 String keyword,
                                 String userId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.keyword = keyword;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }
}