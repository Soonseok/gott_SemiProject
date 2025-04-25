package bookstore.controller;

import java.util.HashMap;
import java.util.Map;

public class CartController {
    private static Map<String, Integer> cartItems = new HashMap<>();

    public static void addToCart(String bookId, int quantity) {
        cartItems.put(bookId, cartItems.getOrDefault(bookId, 0) + quantity);
    }

    public static void removeFromCart(String bookId) {
        cartItems.remove(bookId);
    }

    public static void clearCart() {
        cartItems.clear();
    }

    public static Map<String, Integer> getCartItems() {
        return cartItems;
    }
    
    public static void updateQuantity(String bookId, int quantity) {
        if (quantity <= 0) {
            cartItems.remove(bookId);
        } else {
            cartItems.put(bookId, quantity);
        }
    }
}
