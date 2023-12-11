package oopprojectamal.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import oopprojectamal.interfaces.SalesReportGeneratorI;

public class SalesReportGenerator implements SalesReportGeneratorI {
    private List<SalesTransaction> salesTransactions;
    private List<ProductSalesData> productSalesData;

    public SalesReportGenerator() {
        this.salesTransactions = new ArrayList<>();
        this.productSalesData = new ArrayList<>();
    }

    public void addSalesTransaction(String productName, double amount, String date) {
        SalesTransaction transaction = new SalesTransaction(productName, amount, date);
        salesTransactions.add(transaction);

        // Update product sales data
        updateProductSalesData(productName);
    }

    public void updateProductSalesData(String productName) {
        ProductSalesData existingProductData = productSalesData.stream()
                .filter(data -> data.productName.equals(productName))
                .findFirst()
                .orElse(null);

        if (existingProductData != null) {
            existingProductData.quantitySold++;
        } else {
            productSalesData.add(new ProductSalesData(productName, 1));
        }
    }

    @Override
    public void generateSalesReportByDateRange(String startDate, String endDate) {
        List<SalesTransaction> filteredTransactions = salesTransactions.stream()
                .filter(transaction -> transaction.date.compareTo(startDate) >= 0 && transaction.date.compareTo(endDate) <= 0)
                .collect(Collectors.toList());

        double totalRevenue = calculateTotalRevenue(filteredTransactions);
        String popularProduct = findPopularProduct();

        saveReport("Sales Report for Date Range " + startDate + " to " + endDate);
        saveReport("Total Revenue: " + totalRevenue);
        saveReport("Popular Product: " + popularProduct);
        saveReport(""); // Add an empty line for better readability
    }

    @Override
    public void generateSalesReportByProduct(String productName) {
        List<SalesTransaction> filteredTransactions = salesTransactions.stream()
                .filter(transaction -> transaction.productName.equals(productName))
                .collect(Collectors.toList());

        double totalRevenue = calculateTotalRevenue(filteredTransactions);
        String popularProduct = findPopularProduct();

        saveReport("Sales Report for Product: " + productName);
        saveReport("Total Revenue: " + totalRevenue);
        saveReport("Popular Product: " + popularProduct);
        saveReport(""); // Add an empty line for better readability
    }

    @Override
    public double calculateTotalRevenue(List<SalesTransaction> transactions) {
        return transactions.stream().mapToDouble(transaction -> transaction.amount).sum();
    }

    public String findPopularProduct() {
        ProductSalesData popularProductData = productSalesData.stream()
                .max((p1, p2) -> Integer.compare(p1.quantitySold, p2.quantitySold))
                .orElse(null);

        return (popularProductData != null) ? popularProductData.productName : "No sales data available";
    }

    // Helper method to save reports to a file
    private void saveReport(String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt", true))) {
            writer.write(report);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}