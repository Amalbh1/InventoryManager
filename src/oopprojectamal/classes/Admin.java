
package oopprojectamal.classes;


public class Admin extends User{
  
    public Admin(int userId, String username, String password) {
        super(userId, username, password);
    }

    // Admin-specific methods for updating everything
    public void updateEverything() {
        System.out.println("Admin updating everything");
        // Implement update logic for everything
    }
}


