package use_case.filter_search;

public class FilterSearchInputData {

    private final String searchText;
    private final String category;

    public FilterSearchInputData(String searchText, String category) {
        this.searchText = searchText;
        this.category = category;
    }

    public String getSearchText() {
        return searchText;
    }

    public String getCategory() {
        return category;
    }
}