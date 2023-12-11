
package oopprojectamal.interfaces;

import java.util.List;
import oopprojectamal.classes.SalesTransaction;


public interface SalesReportGeneratorI {
    public void addSalesTransaction(String productName, double amount, String date);
    public void updateProductSalesData(String productName);
    public void generateSalesReportByDateRange(String startDate, String endDate);
    public void generateSalesReportByProduct(String productName); 
    public double calculateTotalRevenue(List<SalesTransaction> transactions);
    public String findPopularProduct();

    
}
