package entity;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final String title;
    private final double amount;
    private String category;


    public Transaction(LocalDate date, String title, double amount) {
        this.date = date;
        this.title = title;
        this.amount = amount;
    }

    public Transaction(LocalDate date, String title, double amount, String category) {
        this.date = date;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getDate() {return date;}
    public double getAmount() {return amount;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getTitle() {return title;}

}

