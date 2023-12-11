
package oopprojectamal.interfaces;

import oopprojectamal.classes.Category;
import oopprojectamal.classes.Product;


public interface ProductInterface {
    public void updateQuantity(int quantity, Product p); 
    public void updatePrice(float price, Product p); 
    public void updateCategory (Category category, Product p); 
}
