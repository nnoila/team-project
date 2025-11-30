package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String username;
    private LocalDate date;
    private String merchant;
    private float amount;
    private String category;

    // Constructor for CSV data
    public Transaction(LocalDate date, String category, double amount, String description, String username) {
        this.date = date;
        this.merchant = description;
        this.amount = (float) amount; 
        this.category = category;
        this.username = username;
    }

    public LocalDate getDate() {return date;}
    public String getMerchant() {return merchant;}
    public String getUsername() {return username;}
    public Float getAmount() { return amount; }
    public String getCategory() { return category; }
    
    public String getMonthYear() {
        return date.getMonth().toString().substring(0, 3) + " " + date.getYear();
    }
    
    public String getDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s | $%.2f | %s", 
            getDateString(), category, amount, merchant);
    }
}
