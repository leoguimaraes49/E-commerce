import java.util.*;

public class ShoppingCart {
    private final Map<Product, Integer> cart = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);
        cart.put(product, currentQuantity + quantity);
        System.out.println("Product added to cart successfully. Cart total is: " + calculateTotal());
    }

    public void removeProduct(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);

        if (currentQuantity > quantity) {
            cart.put(product, currentQuantity - quantity);
        } else if (currentQuantity == quantity) {
            cart.remove(product);
        } else {
            System.out.println("Error: Insufficient quantity to remove from cart.");
            return;
        }

        double updatedTotal = calculateTotal(); // Recalcula o valor total do carrinho após a remoção
        System.out.println("Product removed from cart successfully. Cart total is now: " + updatedTotal);
    }




    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
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
