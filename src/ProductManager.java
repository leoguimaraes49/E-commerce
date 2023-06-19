import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


class ProductManager {
    private Connection connection;

    public ProductManager(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (id, name, price, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.setInt(4, product.getQuantity());
        statement.executeUpdate();
    }

    public void deleteProduct(String id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
    }

    public Product getProductById(String id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Product(resultSet.getString("id"), resultSet.getString("name"), resultSet.getDouble("price"), resultSet.getInt("quantity"));
        }
        return null;
    }
}
