package use_case.filter_search;

import java.util.List;

public interface FilterSearchUserDataAccessInterface {
    List<String> search(String searchText, String category);
}