package entity;

/**
 * Factory for creating CommonUser objects.
 */
public class UserFactory {

    public User create(String name, String userId, String email, String password) {
        return new User(name, userId, email, password);
    }
}
