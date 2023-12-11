
package oopprojectamal.classes;


public class ProductSalesData {
    String productName;
    int quantitySold;

    public ProductSalesData(String productName, int quantitySold) {
        this.productName = productName;
        this.quantitySold = quantitySold;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    @Override
    public String toString() {
        return "ProductSalesData{" + "productName=" + productName + ", quantitySold=" + quantitySold + '}';
    }
}
