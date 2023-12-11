

package oopprojectamal.classes;

import java.util.ArrayList;
import java.util.List;
    import java.util.Scanner;



public class ConsoleMenu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
SalesReportGenerator reportGenerator = new SalesReportGenerator();
        List<Admin> Admins = new ArrayList();
        List<ReportingStaff> ReportingStaffs = new ArrayList(); 
        List<InventoryStaff> InventoryStaffs =new ArrayList(); 
      
        
        while (true) {
            // Display the menu
            System.out.println("Console Menu:");
            System.out.println("1. add Admin");
            System.out.println("2. add Reporting Staff");
            System.out.println("3. add Inventory Staff");
            System.out.println("4. login");
            System.out.println("5. Exit");

            // Prompt the user for input
            System.out.print("Enter your choice: ");

            // Read the user's choice
            int choice = scanner.nextInt();

            // Process the user's choice
            switch (choice) {
                case 1:
                    System.out.println("Adding Admin:");
                    System.out.print("Enter user ID: ");
                    int adminUserId = scanner.nextInt();
                    System.out.print("Enter username: ");
                    String adminUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String adminPassword = scanner.next();
                    Admin admin = new Admin(adminUserId, adminUsername, adminPassword);
                    Admins.add(admin);
                    System.out.println("Admin added successfully!");
                    break;
                    
                   
                case 2:
                    System.out.println("Adding Reporting Staff:");
                    System.out.print("Enter user ID: ");
                    int ReportUserId = scanner.nextInt();
                    System.out.print("Enter username: ");
                    String ReportUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String ReportingStaffPassword = scanner.next();
                    ReportingStaff reportingStaff = new ReportingStaff(ReportUserId, ReportUsername, ReportingStaffPassword);
                    ReportingStaffs.add(reportingStaff);
                    System.out.println("Reporting Staff added successfully!");
                    break;
                case 3:
                    System.out.println("Adding Inventory Staff:");
                    System.out.print("Enter user ID: ");
                    int InventoryUserId = scanner.nextInt();
                    System.out.print("Enter username: ");
                    String InventoryUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String InventoryStaffPassword = scanner.next();
                    InventoryStaff inventoryStaff = new InventoryStaff(InventoryUserId, InventoryUsername, InventoryStaffPassword);
                    InventoryStaffs.add(inventoryStaff);
                    System.out.println("inventory Staff added successfully!");
                    break;
                case 4:
                 // Login logic
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    User loggedInUser = performLogin(username, password, Admins, ReportingStaffs, InventoryStaffs);

                    if (loggedInUser != null) {
                        System.out.println("Login successful!");

                        // Display the user-specific menu
                        displayUserMenu(loggedInUser);

                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
    private static User performLogin(String username, String password, List<Admin> admins,
            List<ReportingStaff> reportingStaffs, List<InventoryStaff> inventoryStaffs) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }

        for (ReportingStaff reportingStaff : reportingStaffs) {
            if (reportingStaff.getUsername().equals(username) && reportingStaff.getPassword().equals(password)) {
                return reportingStaff;
            }
        }

        for (InventoryStaff inventoryStaff : inventoryStaffs) {
            if (inventoryStaff.getUsername().equals(username) && inventoryStaff.getPassword().equals(password)) {
                return inventoryStaff;
            }
        }

        return null;
    }

    private static void displayUserMenu(User user) {
        // Display a customized menu based on the user type
        if (user instanceof Admin) {
            System.out.println("Welcome, Admin!");
            displayAdminMenu();
        } else if (user instanceof ReportingStaff) {
            System.out.println("Welcome, Reporting Staff!");
            displayReportingStaffMenu();
        } else if (user instanceof InventoryStaff) {
            System.out.println("Welcome, Inventory Staff!");
            displayInventoryStaffMenu();
        } else {
            System.out.println("Unknown user type. Exiting...");
            System.exit(0);
        }

        // Add common menu options for all user types if needed
        System.out.println("X. Logout");
        System.out.println("Y. Exit");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String choice = scanner.next();

        switch (choice) {
            case "X":
                // Logout logic, if needed
                break;
            case "Y":
                System.out.println("Exiting the program. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Exiting the program. Goodbye!");
                scanner.close();
                System.exit(0);
        }
    }

    private static void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Admin Menu:");
        System.out.println("1. Find Popular Product");
        System.out.print("Enter your choice: ");
        int adminChoice = scanner.nextInt();

        switch (adminChoice) {
            case 1:
                // Find Popular Product logic
                 SalesReportGenerator reportGenerator = new SalesReportGenerator();

                 reportGenerator.addSalesTransaction("Product A", 100.0, "2023-01-01");
                 reportGenerator.addSalesTransaction("Product B", 150.0, "2023-01-02");
                 reportGenerator.addSalesTransaction("Product A", 120.0, "2023-01-03");
                 reportGenerator.generateSalesReportByProduct("Product A");

 
                break;
            // Add other admin-specific options and logic here
            default:
                System.out.println("Invalid choice. Exiting the program. Goodbye!");
                System.exit(0);
        }
    }

    private static void displayReportingStaffMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reporting Staff Menu:");
        System.out.println("1. Generate Sales Report by Date Range");
        System.out.print("Enter your choice: ");
        int reportingStaffChoice = scanner.nextInt();

        switch (reportingStaffChoice) {
            case 1:
                 SalesReportGenerator reportGenerator = new SalesReportGenerator();

        reportGenerator.addSalesTransaction("Product A", 100.0, "2023-01-01");
        reportGenerator.addSalesTransaction("Product B", 150.0, "2023-01-02");
        reportGenerator.addSalesTransaction("Product A", 120.0, "2023-01-03");

        reportGenerator.generateSalesReportByDateRange("2023-01-01", "2023-01-03");
        
                System.out.println("Executing Generate Sales Report by Date Range logic...");
                break;
            default:
                System.out.println("Invalid choice. Exiting the program. Goodbye!");
                System.exit(0);
        }
    }

    private static void displayInventoryStaffMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inventory Staff Menu:");
        System.out.println("1. Add Product");
        System.out.print("Enter your choice: ");
        int inventoryStaffChoice = scanner.nextInt();

        switch (inventoryStaffChoice) {
            case 1:
                // Add Product logic
               
SalesReportGenerator reportGenerator = new SalesReportGenerator();

        reportGenerator.addSalesTransaction("Product A", 100.0, "2023-01-01");
        reportGenerator.addSalesTransaction("Product B", 150.0, "2023-01-02");
        reportGenerator.addSalesTransaction("Product A", 120.0, "2023-01-03");
                System.out.println("Executing Add Product logic...");
                break;
            // Add other inventory staff-specific options and logic here
            default:
                System.out.println("Invalid choice. Exiting the program. Goodbye!");
                System.exit(0);
        }
    }
    
}
