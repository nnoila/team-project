package entity;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private final double amount;
    private final String description;
    private String category; // assigned by AI after upload

    public Transaction(LocalDate date, String category, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.category = "Uncategorized";
    }

    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }

    public void setCategory(String category) {
        this.category = category;
    }
}
