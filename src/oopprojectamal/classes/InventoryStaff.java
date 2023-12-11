
package oopprojectamal.classes;


public class InventoryStaff extends User {
      public InventoryStaff(int userId, String username, String password) {
        super(userId, username, password);
    }

    // InventoryStaff-specific methods for updating inventory-related stuff
    public void updateInventory() {
        System.out.println("InventoryStaff updating inventory");
        // Implement update logic for inventory-related stuff
    }
}
