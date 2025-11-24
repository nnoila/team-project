package model;

/**
 * Represents a single financial transaction for a user.
 */
public class Transaction {
    private int transactionId;
    private int userId;
    private String description;
    private double amount;
    private String category; // Will be set by categorizer

    public Transaction(int transactionId, int userId, String description, double amount) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.category = "Uncategorized"; // default category
    }

    // Getters and setters
    public int getTransactionId() { return transactionId; }
    public int getUserId() { return userId; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
