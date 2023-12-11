
package oopprojectamal.classes;


public class Main {

 
  public static void main(String[] args) {
        SalesReportGenerator reportGenerator = new SalesReportGenerator();

        reportGenerator.addSalesTransaction("Product A", 100.0, "2023-01-01");
        reportGenerator.addSalesTransaction("Product B", 150.0, "2023-01-02");
        reportGenerator.addSalesTransaction("Product A", 120.0, "2023-01-03");

        reportGenerator.generateSalesReportByDateRange("2023-01-01", "2023-01-03");
        reportGenerator.generateSalesReportByProduct("Product A");
        
    }
}

