import java.util.Scanner;

public class Admin {
    private String name;
    private static final String adminUsername = "admin";
    private static final String adminPassword = "password";

    public Admin(String name) {
        this.name = name;
    }

    public static boolean authenticate(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        PolicyManager policyManager = new PolicyManager();

        while (true) {
            System.out.println("Welcome, Admin! Choose an operation:");
            System.out.println("1. Add Policy");
            System.out.println("2. Delete Policy");
            System.out.println("3. View Policies");
            System.out.println("4. View Sales Report");
            System.out.println("5. Exit Admin Menu");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> policyManager.addPolicy();
                case 2 -> policyManager.deletePolicy();
                case 3 -> policyManager.viewPolicies();
                case 4 -> Sales.viewReport();
                case 5 -> {
                    System.out.println("Exiting Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
