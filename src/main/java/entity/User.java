package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple entity representing a user. Users have userid, name, email, encrypted password, preferences and alert
 * thresholds.
 */
public class User {

    private final String userId;
    private final String name;
    private final String email;
    private final String passwordHash;
    private final UserPreferences preferences;
    private final Map<String, Float> alertThresholds;

    /**
     * Creates a new user with the given non-empty user id, name, email, encrypted password, default preferences, and
     * alert thresholds.
     * @param userId the user id
     * @param name the name
     * @param email the email
     * @param passwordHash the encrypted password
     * @throws IllegalArgumentException if the name, user id, email, and encrypted password are empty
     */
    public User(String userId, String name, String email, String passwordHash) {
        if ("".equals(name) || "".equals(userId) || "".equals(email) || "".equals(passwordHash)) {
            throw new IllegalArgumentException("Field(s) cannot be empty or null");
        }

        this.name = name;
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.preferences = new UserPreferences();
        this.alertThresholds = new HashMap<>();
    }

    public boolean authenticatePassword(String otherPasswordHash) {
        return otherPasswordHash.equals(passwordHash);
    }

    public void addAlertThreshold(String category, float threshold) {
        alertThresholds.put(category, threshold);
    }

    public String getUserId() { return userId; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPasswordHash() { return passwordHash; }

    public UserPreferences getPreferences() { return preferences; }

    public Map<String, Float> getAlertThresholds() { return alertThresholds; }

}
