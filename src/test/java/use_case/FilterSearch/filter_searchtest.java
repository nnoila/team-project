package use_case.FilterSearch;

import entity.FilterSearchUser;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilterSearchInteractorTest {

    @Test
    void successTest() {

        // Fake Data Access
        FilterSearchUserDataAccessInterface fakeRepo = new FilterSearchUserDataAccessInterface() {
            @Override
            public List<FilterSearchUser> filterUsers(String start, String end, String category, String keyword) {
                return List.of(
                        new FilterSearchUser("1", "Anika", "anika@test.com"),
                        new FilterSearchUser("2", "John", "john@test.com")
                );
            }
        };

        // Fake Presenter
        FilterSearchOutputBoundary presenter = new FilterSearchOutputBoundary() {
            @Override
            public void prepareSuccessView(FilterSearchOutputData data) {
                assertEquals(2, data.getMatchedUsers().size());
                assertEquals("2 results found", data.getMessage());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Should not reach fail view in this test.");
            }
        };

        // Create interactor
        FilterSearchInteractor interactor =
                new FilterSearchInteractor(fakeRepo, presenter);

        // Create input data
        FilterSearchInputData input = new FilterSearchInputData(
                "2025-01-01",
                "2025-01-31",
                "shopping",
                "nike",
                "user123"
        );

        // Execute
        interactor.execute(input);
    }
}
