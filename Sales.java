import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sales {
    public static void viewReport() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM sales";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Sales Report:");
            while (resultSet.next()) {
                System.out.println("Sale ID: " + resultSet.getInt("id") +
                        ", Customer: " + resultSet.getString("customer_name") +
                        ", Policy ID: " + resultSet.getInt("policy_id") +
                        ", Amount: " + resultSet.getDouble("amount") +
                        ", Date: " + resultSet.getDate("date"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving sales report: " + e.getMessage());
        }
    }
}
