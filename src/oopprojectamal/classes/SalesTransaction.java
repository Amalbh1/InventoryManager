
package oopprojectamal.classes;

import java.util.Date;


    public class SalesTransaction {
    String productName;
    double amount;
    String date;

    public SalesTransaction(String productName, double amount, String date) {
        this.productName = productName;
        this.amount = amount;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesTransaction{" + "productName=" + productName + ", amount=" + amount + ", date=" + date + '}';
    }
}
