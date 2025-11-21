package use_case.filter_search;

import entity.FilterSearchUser;
import java.util.List;

public interface FilterSearchUserDataAccessInterface {
    List<FilterSearchUser> filterUsers(String startDate, String endDate, String category, String keyword);
}
