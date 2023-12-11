
package oopprojectamal.classes;

import java.util.ArrayList;
import java.util.List;
import oopprojectamal.interfaces.InventoryManagerInterface;


 
public class InventoryManager implements InventoryManagerInterface {
    List<Product> products= new ArrayList(); 

    public InventoryManager() {
    }

    @Override
    public void add(Product p) {
        products.add(p);
        
        }

    @Override
    public void remove(Product p) {
        products.remove(p);
    }

    @Override
    public void update(Product p, Product p1) {
        products.set(products.indexOf(p), p1);
        
    }
   
    
}
