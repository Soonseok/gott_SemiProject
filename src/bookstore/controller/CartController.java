package bookstore.controller;

import bookstore.model.BookRepository;
import bookstore.model.Cart;
import java.util.Map;

public class CartController {

    private static Cart cart = new Cart();

    public static void addToCart(String bookId, int quantity) {
        cart.addToCart(bookId, quantity);
    }

    public static void removeFromCart(String bookId) {
        cart.removeFromCart(bookId);
    }

    public static void clearCart() {
        cart.clearCart();
    }

    public static Map<String, Integer> getCartItems() {
        return cart.getCartItems();
    }

    public static void updateQuantity(String bookId, int quantity) {
        cart.updateQuantity(bookId, quantity);
    }

    public static int getTotalPrice(BookRepository repo) {
        return cart.getTotalPrice(repo);
    }

}
