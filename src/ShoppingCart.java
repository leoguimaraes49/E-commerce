import java.util.*;

public class ShoppingCart {
    private Map<Product, Integer> cart = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);
        cart.put(product, currentQuantity + quantity);
        System.out.println("Product added to cart successfully. Cart total is: " + calculateTotal());
    }

    public void removeProduct(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);

        if (currentQuantity >= quantity) {
            cart.put(product, currentQuantity - quantity);
        } else {
            cart.remove(product);
        }
        System.out.println("Product removed from cart successfully. Cart total is: " + calculateTotal());
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }

    public void showCart() {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println("Product ID: " + entry.getKey().getId() + ", Quantity: " + entry.getValue());
        }
    }

    public void clearCart() {
        cart.clear();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }
}