package entity;

import java.util.Date;

public class Transaction {

    private final int transactionId;   // Unique ID for this transaction
    private final int userId;          // Which user this belongs to
    private final Date date;           // When the transaction happened
    private final String description;  // Merchant or transaction details
    private final float amount;        // Money spent or received
    private final int categoryId;      // Category (groceries, shopping, etc.)

    public Transaction(int transactionId,
                       int userId,
                       Date date,
                       String description,
                       float amount,
                       int categoryId) {

        this.transactionId = transactionId;
        this.userId = userId;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public float getAmount() {
        return amount;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
