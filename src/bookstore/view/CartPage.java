package bookstore.view;

import bookstore.controller.CartController;
import bookstore.controller.CreateBookPanels;
import bookstore.controller.PageController;
import bookstore.model.Book;
import bookstore.model.BookRepository;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class CartPage extends BasePage {

    JPanel bookPanel, totalBookPanel;
    JPanel[] bookPanels;
    JButton removeBtn, clearAllBtn;
    JLabel totalLabel, totalQuntiyLabel;
    List<Book> BookData;

    public CartPage() {
        mainPanel.setBackground(Color.GREEN);
        totalBookPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        totalBookPanel.setLayout(new BoxLayout(totalBookPanel, BoxLayout.Y_AXIS));

        bookPanel = new JPanel();
        Map<String, Integer> cartItems = CartController.getCartItems();; // 책 ID, 수량
        BookRepository repo = new BookRepository();
        String[][] books = repo.getBooksByIds(new ArrayList<>(cartItems.keySet()));

        if (books.length == 0) {
            JLabel emptyAllert = new JLabel("장바구니가 비어 있습니다.");
            emptyAllert.setFont(new Font("맑은 고딕", Font.BOLD, 30));
            mainPanel.add(emptyAllert);
        } else {

            int totalPrice = 0;
            for (int k = 0; k < books.length; k++) {
                final int index = k;

                String[] bookDatum = new String[7];
                bookDatum[0] = books[index][0]; // 책id
                bookDatum[1] = books[index][1]; // 저자
                bookDatum[2] = books[index][2]; // 제목
                bookDatum[3] = books[index][3]; // 가격
                bookDatum[4] = books[index][4]; // 파일 경로
                bookDatum[5] = "";
                bookDatum[6] = "";

                bookPanels = CreateBookPanels.createSingleBookPanelX(bookDatum);

                JPanel singleBookPanel = new JPanel();
                singleBookPanel.setLayout(new BoxLayout(singleBookPanel, BoxLayout.X_AXIS));
                singleBookPanel.add(bookPanels[0]);

                int quantity = cartItems.get(books[index][0]);
                int unitPrice = Integer.parseInt(books[index][3]);
                int bookTotal = unitPrice * quantity;
                totalPrice += bookTotal;

                totalQuntiyLabel = new JLabel("총 " + quantity + " 권  ");
                JLabel priceLabel = new JLabel(bookTotal + "원");
                priceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));

                JButton removeBtn = new JButton("삭제");
                removeBtn.addActionListener(e -> {
                    int ans = JOptionPane.showConfirmDialog(null, bookDatum[2] + "을(를) 삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
                    if (ans == 0) {
                        CartController.removeFromCart(books[index][0]);
                        PageController.showCartPage();
                    }
                });
                JPanel priceSetPanel = new JPanel();
                priceSetPanel.setLayout(new BoxLayout(priceSetPanel, BoxLayout.Y_AXIS));
                priceSetPanel.add(totalQuntiyLabel);
                priceSetPanel.add(Box.createVerticalStrut(10));
                priceSetPanel.add(priceLabel);
                priceSetPanel.add(Box.createVerticalStrut(10));
                priceSetPanel.add(removeBtn);
                singleBookPanel.add(priceSetPanel);
                totalBookPanel.add(singleBookPanel);
                totalBookPanel.add(Box.createVerticalStrut(10));
            }

            totalLabel = new JLabel("총 가격: " + totalPrice + " 원  ");
            totalLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
            clearAllBtn = new JButton("전체 삭제");
            clearAllBtn.addActionListener(e -> {
                int ans = JOptionPane.showConfirmDialog(null, "모두 삭제 하시겠습니까?", "전체 삭제", JOptionPane.YES_NO_OPTION);
                if (ans == 0) {
                    CartController.clearCart();
                    PageController.showCartPage();
                } else {
                }
            });

            totalBookPanel.add(Box.createVerticalStrut(10));
            totalBookPanel.add(totalLabel);
            totalBookPanel.add(Box.createVerticalStrut(10));
            totalBookPanel.add(clearAllBtn);
            //mainPanel.add(totalBookPanel);

            JScrollPane scrollPane = new JScrollPane(totalBookPanel,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 부드럽게

            // 크기를 mainPanel에 맞춰줌
            scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
            scrollPane.setPreferredSize(new Dimension(800, 600)); // 이건 화면 크기에 따라 조정

            // mainPanel에 제목 + 스크롤 붙이기
            mainPanel.add(scrollPane);
        }
    }

    public JPanel getCartPage() {
        return basePanel;
    }
}
