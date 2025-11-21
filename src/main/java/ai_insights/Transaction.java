package ai_insights;

import java.time.LocalDate;

public class Transaction {
     public String userId;
     public LocalDate date;
     public String description;
     public int transactionId;
     public String category;
     public int amount;

     public int getAmount() {
        return amount;
     }

     public String getUserId() {
         return this.userId;
     }

     public LocalDate getDate() {
         return this.date;
     }

     public String getDescription() {
         return this.description;
     }

     public int getTransactionId() {
         return this.transactionId;
     }

     public String getCategory() {
         return this.category;
     }

     public void setUserId(String userId) {
         this.userId = userId;
     }

     public void setDate(LocalDate date) {
         this.date = date;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public void setTransactionId(int transactionId) {
         this.transactionId = transactionId;
     }

     public void setCategory(String category) {
         this.category = category;
     }

     public void setAmount(int amount) {
         this.amount = amount;
     }
}
