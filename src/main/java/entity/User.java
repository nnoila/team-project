package entity;

/**
 * A simple entity representing a user. Users have a name, email, password, and userId.
 */
public class User {

    private final String name;
    private final String userId;
    private final String email;
    private final String password;

    /**
     * Creates a new user with the given non-empty name and non-empty password.
     * @param name the name
     * @param userId the user id
     * @param email the email
     * @param password the password
     * @throws IllegalArgumentException if the name, user id, email or password are empty
     */
    public User(String name, String userId, String email, String password) {
        if ("".equals(name) || "".equals(userId) || "".equals(email) || "".equals(password)) {
            throw new IllegalArgumentException("Field(s) cannot be empty or null");
        }

        this.name = name;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserId() { return userId; }

    public String getEmail() { return email; }

    public String getPassword() {
        return password;
    }

}
