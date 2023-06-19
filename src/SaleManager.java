import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SaleManager {
    private ProductManager productManager;
    private ShoppingCart shoppingCart;
    private Connection connection;

    public SaleManager(ProductManager productManager, ShoppingCart shoppingCart, Connection connection) {
        this.productManager = productManager;
        this.shoppingCart = shoppingCart;
        this.connection = connection;
    }

    public boolean confirmSale() throws SQLException {
        String sql = "UPDATE products SET quantity = quantity - 1 WHERE id = ?";
        for (Product product : shoppingCart.getProducts()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getId());
            statement.executeUpdate();
        }
        return true;
    }
}
