import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Insurance Management System!");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Admin Username: ");
                    String username = scanner.next();
                    System.out.print("Enter Admin Password: ");
                    String password = scanner.next();

                    if (Admin.authenticate(username, password)) {
                        new Admin("Admin").adminMenu();
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.next();
                    new Customer(customerName).customerMenu();
                }
                case 3 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
