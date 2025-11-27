package entity;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final double amount;
    private String category;

    public Transaction(LocalDate date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }
    public LocalDate getDate() {return date;}
    public double getAmount() {return amount;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

}

