package bookstore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<String, Integer> cartItems = new HashMap<>();

    public Cart(Map<String, Integer> items) {
        this.cartItems = new HashMap<>(items);
    }    
    public Cart() {
        this.cartItems = new HashMap<>();
    }    

    public void addToCart(String bookId, int quantity) {
        cartItems.put(bookId, cartItems.getOrDefault(bookId, 0) + quantity);
    }

    public void removeFromCart(String bookId) {
        cartItems.remove(bookId);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public Map<String, Integer> getCartItems() {
        return new HashMap<>(cartItems); // 혹시 외부에서 수정 못 하게 복사본 리턴
    }

    public void updateQuantity(String bookId, int quantity) {
        if (cartItems.containsKey(bookId)) {
            if (quantity > 0) {
                cartItems.put(bookId, quantity);
            } else {
                cartItems.remove(bookId);
            }
        }
    }    

    public int getTotalPrice(BookRepository repo) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String bookId = entry.getKey();
            int quantity = entry.getValue();
            String[][] bookData = repo.getBooksByIds(new ArrayList<>(List.of(bookId)));
            if (bookData.length > 0) {
                int price = Integer.parseInt(bookData[0][3]); // [0][3] = 가격
                total += price * quantity;
            }
        }
        return total;
    }
}
