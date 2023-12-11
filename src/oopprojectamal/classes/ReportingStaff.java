
package oopprojectamal.classes;


public class ReportingStaff extends User{ public ReportingStaff(int userId, String username, String password) {
        super(userId, username, password);
    }

    // ReportingStaff-specific methods for updating reporting-related stuff
    public void updateReporting() {
        System.out.println("ReportingStaff updating reporting");
        // Implement update logic for reporting-related stuff
    }
    
}
