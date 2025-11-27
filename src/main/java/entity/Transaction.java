package entity;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final String description;
    private final double amount;
    private String category;


    public Transaction(LocalDate date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public Transaction(LocalDate date, String description, double amount, String category) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getDate() {return date;}
    public double getAmount() {return amount;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getDescription() {return description;}

}
