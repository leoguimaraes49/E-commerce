import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce_db", "root", "leo123");
            ProductManager productManager = new ProductManager(connection);
            ShoppingCart shoppingCart = new ShoppingCart();
            SaleManager saleManager = new SaleManager(productManager, shoppingCart, connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Add a product");
                System.out.println("2. Delete a product");
                System.out.println("3. Add a product to the cart");
                System.out.println("4. Confirm sale");
                System.out.println("5. Exit");
                System.out.print("Select an option: ");

        String option = scanner.nextLine();

        switch (option) {
        case "1":
        System.out.print("Enter the product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Product product = new Product(id, name, price, quantity);
        productManager.addProduct(product);
        break;

        case "2":
        System.out.print("Enter the product ID to delete: ");
        String deleteId = scanner.nextLine();
        productManager.deleteProduct(deleteId);
        break;

        case "3":
        System.out.print("Enter the product ID to add to the cart: ");
        String cartId = scanner.nextLine();
        Product cartProduct = productManager.getProductById(cartId);
        shoppingCart.addProduct(cartProduct);
        break;

        case "4":
        if (saleManager.confirmSale()) {
        System.out.println("Sale confirmed");
        } else {
        System.out.println("Sale not confirmed");
        }
        break;

        case "5":
        System.out.println("Exiting...");
        return;

default:
        System.out.println("Invalid option");
        }
        }
        } catch (SQLException e) {
        throw new RuntimeException("Error connecting to the database", e);
        }
        }
        }
