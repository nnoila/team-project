package use_case.filter_search;

import java.util.List;

public class FilterSearchOutputData {

    private final List<String> matchedUsers;

    private final String message;

    public FilterSearchOutputData(List<String> matchedUsers, String message) {
        this.matchedUsers = matchedUsers;
        this.message = message;
    }

    public List<String> getMatchedUsers() {
        return matchedUsers;
    }

    public String getMessage() {
        return message;
    }
}
