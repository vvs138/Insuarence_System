import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PolicyManager {
    private final Scanner scanner = new Scanner(System.in);

    public void addPolicy() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter Policy ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Policy Name: ");
            String name = scanner.next();
            System.out.print("Enter Premium Amount: ");
            double premium = scanner.nextDouble();
            System.out.print("Enter Coverage Amount: ");
            double coverage = scanner.nextDouble();

            String sql = "INSERT INTO policies (id, name, premium, coverage) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, premium);
            statement.setDouble(4, coverage);

            statement.executeUpdate();
            System.out.println("Policy added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding policy: " + e.getMessage());
        }
    }

    public void deletePolicy() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter Policy ID to delete: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM policies WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Policy deleted successfully!");
            } else {
                System.out.println("Policy ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting policy: " + e.getMessage());
        }
    }

    public void viewPolicies() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM policies";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Policy List:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Premium: " + resultSet.getDouble("premium") +
                        ", Coverage: " + resultSet.getDouble("coverage"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving policies: " + e.getMessage());
        }
    }
}
