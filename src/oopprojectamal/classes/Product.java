
package oopprojectamal.classes;

import oopprojectamal.interfaces.ProductInterface;


public class Product implements ProductInterface{
    int productId; 
    String productname; 
    int quantityInStock; 
    float price; 
    Category category; 

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productname=" + productname + ", quantityInStock=" + quantityInStock + ", price=" + price + ", category=" + category + '}';
    }

    public Product() {
    }

    public Product(int productId, String productname, int quantityInStock, float price, Category category) {
        this.productId = productId;
        this.productname = productname;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.category = category;
    }

    @Override
    public void updateQuantity(int quantity, Product p) {
        p.setQuantityInStock(quantity);
    }

    @Override
    public void updatePrice(float price, Product p) {
        p.setPrice(price);
    }

   
    public void updateCategory(Category category, Product p) {
        p.setCategory(category);
    }
    

}