package entity;

public class Transaction {
    private final String description;
    private final double amount;
    private String category;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.category = "Uncategorized";
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
