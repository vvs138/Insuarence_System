import java.util.Scanner;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        PolicyManager policyManager = new PolicyManager();

        while (true) {
            System.out.println("Welcome, " + name + "! Choose an operation:");
            System.out.println("1. View Policies");
            System.out.println("2. Purchase Policy");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> policyManager.viewPolicies();
                case 2 -> SalesManager.purchasePolicy(name);
                case 3 -> {
                    System.out.println("Exiting Customer Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
