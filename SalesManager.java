import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SalesManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void purchasePolicy(String customerName) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter Policy ID to purchase: ");
            int policyId = scanner.nextInt();
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();

            String sql = "INSERT INTO sales (customer_name, policy_id, amount, date) VALUES (?, ?, ?, CURDATE())";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerName);
            statement.setInt(2, policyId);
            statement.setDouble(3, amount);

            statement.executeUpdate();
            System.out.println("Policy purchased successfully!");
        } catch (SQLException e) {
            System.out.println("Error purchasing policy: " + e.getMessage());
        }
    }
}
