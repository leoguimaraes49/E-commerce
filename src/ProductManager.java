import java.sql.*;

public class ProductManager {
    private final Connection connection;

    public ProductManager(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (id, name, price, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.id ());
            stmt.setString(2, product.name ());
            stmt.setDouble(3, product.price ());
            stmt.setInt(4, product.quantity ());
            stmt.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public Product getProduct(String productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                return new Product(id, name, price, quantity);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving product: " + e.getMessage());
        }
        return null;
    }

    public void showProducts() {
        String sql = "SELECT * FROM products";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                System.out.println("Product ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity in Stock: " + quantity);
            }

        } catch (SQLException e) {
            System.out.println("Error displaying products: " + e.getMessage());
        }
    }
}