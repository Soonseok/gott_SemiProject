package bookstore.view;

import bookstore.controller.CartController;
import bookstore.controller.CreateBookPanels;
import bookstore.controller.PageController;
import static bookstore.controller.PageController.previousPageHistory;
import bookstore.model.Book;
import bookstore.model.BookRepository;
import bookstore.view.component.QuantitySelector;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class CartPage extends BasePage {

    JPanel bookPanel, totalBookPanel;
    JPanel[] bookPanels;
    JButton removeBtn, clearAllBtn, payBtn;
    JLabel totalLabel, totalQuntiyLabel;
    List<Book> BookData;

    public CartPage() {
        mainPanel.setBackground(Color.GREEN);
        totalBookPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        totalBookPanel.setLayout(new BoxLayout(totalBookPanel, BoxLayout.Y_AXIS));

        bookPanel = new JPanel();
        BookRepository repo = new BookRepository();
        Map<String, Integer> cartItems = CartController.getCartItems();
        String[][] books = repo.getBooksByIds(new ArrayList<>(cartItems.keySet()));

        if (books.length == 0) {
            JLabel emptyAllert = new JLabel("장바구니가 비어 있습니다.");
            emptyAllert.setFont(new Font("맑은 고딕", Font.BOLD, 30));
            emptyAllert.setAlignmentX(emptyAllert.CENTER_ALIGNMENT);
            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(emptyAllert);
            mainPanel.add(Box.createVerticalGlue());
        } else {

            for (int k = 0; k < books.length; k++) {
                final int index = k;
                final String bookId = books[index][0];

                String[] bookDatum = new String[7];
                bookDatum[0] = books[index][0];
                bookDatum[1] = books[index][1];
                bookDatum[2] = books[index][2];
                bookDatum[3] = books[index][3];
                bookDatum[4] = books[index][4];
                bookDatum[5] = "";
                bookDatum[6] = "";

                bookPanels = CreateBookPanels.createSingleBookPanelX(bookDatum);

                JPanel singleBookPanel = new JPanel();
                singleBookPanel.setLayout(new BoxLayout(singleBookPanel, BoxLayout.X_AXIS));
                singleBookPanel.add(bookPanels[0]);

                int quantity = cartItems.get(bookId);
                int unitPrice = Integer.parseInt(books[index][3]);
                int bookTotal = unitPrice * quantity;

                JLabel priceLabel = new JLabel(bookTotal + "원");
                priceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));

                QuantitySelector quantitySelector = new QuantitySelector();
                quantitySelector.setQuantity(quantity);
                quantitySelector.bindTotalPriceLabel(priceLabel, unitPrice);
                quantitySelector.setOnQuantityChange(newQty -> {
                    CartController.updateQuantity(bookId, newQty); // cart에 수량 반영
                    totalLabel.setText("총 가격: " + CartController.getTotalPrice(repo) + " 원");
                });

                JButton plusBtn = new JButton("+");
                JButton minusBtn = new JButton("-");

                plusBtn.addActionListener(e -> {
                    int currentQty = quantitySelector.getQuantity();
                    CartController.updateQuantity(bookId, currentQty + 1);
                    PageController.showCartPage();
                });

                minusBtn.addActionListener(e -> {
                    int currentQty = quantitySelector.getQuantity();
                    CartController.updateQuantity(bookId, currentQty - 1);
                    PageController.showCartPage();
                });

                removeBtn = new JButton("삭제");
                removeBtn.addActionListener(e -> {
                    int ans = JOptionPane.showConfirmDialog(null, bookDatum[2] + "을(를) 삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
                    if (ans == 0) {
                        CartController.removeFromCart(bookId);
                        PageController.showCartPage();
                        if(!previousPageHistory.isEmpty()){
                            previousPageHistory.pop();
                        }
                    }
                });

                JPanel priceSetPanel = new JPanel();
                priceSetPanel.setLayout(new BoxLayout(priceSetPanel, BoxLayout.Y_AXIS));
                priceSetPanel.setMaximumSize(new Dimension(250, 100));
                priceSetPanel.setPreferredSize(new Dimension(250, 100));
                priceSetPanel.add(Box.createVerticalGlue());
                priceSetPanel.add(quantitySelector);
                priceSetPanel.add(Box.createVerticalStrut(10));
                priceSetPanel.add(priceLabel);
                priceSetPanel.add(Box.createVerticalGlue());
                priceSetPanel.add(removeBtn);
                priceSetPanel.add(Box.createVerticalGlue());

                singleBookPanel.add(priceSetPanel);
                totalBookPanel.add(singleBookPanel);
                totalBookPanel.add(Box.createVerticalStrut(10));
            }

            int totalPrice = CartController.getTotalPrice(repo);

            totalLabel = new JLabel("총 가격: " + totalPrice + " 원  ");
            totalLabel.setBackground(new Color(252, 200, 155));
            totalLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));

            clearAllBtn = new JButton("전체 삭제");
            clearAllBtn.addActionListener(e -> {
                int ans = JOptionPane.showConfirmDialog(null, "모두 삭제 하시겠습니까?", "전체 삭제", JOptionPane.YES_NO_OPTION);
                if (ans == 0) {
                    CartController.clearCart();
                    PageController.showCartPage();
                    previousPageHistory.pop();
                }
            });

            payBtn = new JButton("결제");
            payBtn.addActionListener(e -> {
                int updatedTotalPrice = CartController.getTotalPrice(repo);
                PageController.showPaymentPage(updatedTotalPrice);
            });

            totalBookPanel.add(Box.createVerticalStrut(10));
            totalBookPanel.add(totalLabel);
            totalBookPanel.add(Box.createVerticalStrut(10));
            totalBookPanel.add(clearAllBtn);
            totalBookPanel.add(Box.createVerticalStrut(10));
            totalBookPanel.add(payBtn);

            JScrollPane scrollPane = new JScrollPane(totalBookPanel,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);

            scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
            scrollPane.setPreferredSize(new Dimension(800, 600));

            mainPanel.add(scrollPane);
        }
    }

    public JPanel getCartPage() {
        return basePanel;
    }
}
