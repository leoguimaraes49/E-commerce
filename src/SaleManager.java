import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class SaleManager {
    private final ShoppingCart shoppingCart;
    private final Connection connection;

    public SaleManager(ShoppingCart shoppingCart, Connection connection) {
        this.shoppingCart = shoppingCart;
        this.connection = connection;
    }

    public void confirmSale() throws SQLException {
        String query = "UPDATE products SET quantity = quantity - ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (Map.Entry<Product, Integer> entry : shoppingCart.getCart().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, product.getId());
            preparedStatement.executeUpdate();
        }

        shoppingCart.clearCart();
    }
}