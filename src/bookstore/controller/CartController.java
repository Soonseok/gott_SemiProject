package bookstore.controller;

import bookstore.dao.CartDAO;
import bookstore.login.LoginController;
import bookstore.model.BookRepository;
import bookstore.model.Cart;
import java.util.Map;

public class CartController {

    private static Cart guestCart = new Cart(); // 비회원용
    private static String currentUserId = null; // 로그인한 사용자 ID (없으면 guest)

    public static void login(String userId, String userName) {
        if(LoginController.isLoggedIn()){
            currentUserId = LoginController.getLoggedInUserName();
        }else{
            currentUserId = userId;
        }
        guestCart.clearCart(); // 로그인 시 guestCart 초기화
    }

    public static void logout() {
        currentUserId = null;
    }

    public static void addToCart(String bookId, int quantity) {
        System.out.println(currentUserId);
        if (LoginController.isLoggedIn()) {
            CartDAO.addOrUpdateItem(LoginController.getLoggedInUserName(), bookId, quantity);
        } else {
            guestCart.addToCart(bookId, quantity);
        }
    }

    public static void removeFromCart(String bookId) {
        if (LoginController.isLoggedIn()) {
            CartDAO.removeItem(LoginController.getLoggedInUserName(), bookId);
        } else {
            guestCart.removeFromCart(bookId);
        }
    }

    public static void clearCart() {
        if (LoginController.isLoggedIn()) {
            CartDAO.clearCart(LoginController.getLoggedInUserName());
        } else {
            guestCart.clearCart();
        }
    }

    public static Map<String, Integer> getCartItems() {
        if (LoginController.isLoggedIn()) {
            return CartDAO.getCartItems(LoginController.getLoggedInUserName());
        } else {
            return guestCart.getCartItems();
        }
    }

    public static void updateQuantity(String bookId, int quantity) {
        if (LoginController.isLoggedIn()) {
            CartDAO.updateQuantity(LoginController.getLoggedInUserName(), bookId, quantity);
        } else {
            guestCart.updateQuantity(bookId, quantity);
        }
    }

    public static int getTotalPrice(BookRepository repo) {
        if (LoginController.isLoggedIn()) {
            Map<String, Integer> items = CartDAO.getCartItems(LoginController.getLoggedInUserName());
            return new Cart(items).getTotalPrice(repo);
        } else {
            return guestCart.getTotalPrice(repo);
        }
    }
}
