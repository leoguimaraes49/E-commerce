import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "user", "password");

            ProductManager productManager = new ProductManager(connection);
            ShoppingCart shoppingCart = new ShoppingCart();
            SaleManager saleManager = new SaleManager(shoppingCart, connection);

            Scanner scanner = new Scanner(System.in);
            boolean run = true;

            while(run) {
                System.out.println("1 - Add product to stock");
                System.out.println("2 - Add product to cart");
                System.out.println("3 - Remove product from cart");
                System.out.println("4 - Show products in stock");
                System.out.println("5 - Show products in cart");
                System.out.println("6 - Confirm sale");
                System.out.println("0 - Exit");
                System.out.println("Select an option:");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch(option) {
                    case 1:
                        System.out.println("Enter product details (id, name, price, quantity):");
                        String[] details = scanner.nextLine().split(",");
                        Product product = new Product(details[0], details[1], Double.parseDouble(details[2]), Integer.parseInt(details[3]));
                        productManager.addProduct(product);
                        System.out.println("Product added to stock successfully");
                        break;

                    case 2:
                        System.out.println("Enter product ID and quantity: (use \" , \" to separate id from quantity)");
                        String[] cartDetails = scanner.nextLine().split(",");
                        shoppingCart.addProduct(productManager.getProduct(cartDetails[0]), Integer.parseInt(cartDetails[1]));
                        System.out.println("Product added to cart successfully");
                        System.out.println("Cart total value is now: " + shoppingCart.calculateTotal());
                        break;

                    case 3:
                        System.out.println("Enter product ID and quantity to remove from cart:");
                        String[] removeDetails = scanner.nextLine().split(",");
                        shoppingCart.removeProduct(productManager.getProduct(removeDetails[0]), Integer.parseInt(removeDetails[1]));
                        System.out.println("Product removed from cart successfully");
                        System.out.println("Cart total value is now: " + shoppingCart.calculateTotal());
                        break;

                    case 4:
                        productManager.showProducts();
                        break;

                    case 5:
                        shoppingCart.showCart();
                        break;

                    case 6:
                        saleManager.confirmSale();
                        System.out.println("Sale confirmed successfully");
                        break;

                    case 0:
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

            scanner.close();
            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
