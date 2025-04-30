package bookstore.view;

import bookstore.controller.CartController;
import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;
import bookstore.model.BookRepository;
import bookstore.view.component.QuantitySelector;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class DetailPage extends BasePage {

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextArea titleArea, authorArea;
    // String[][] BookData = Book.TestBookData;
    List<Book> BookData;
    JPanel detailPanel, leftPanel, rightPanel, titlePanel, authorPanel, pricePanel, totalPricePanel;
    JPanel[] bookPanel;
    JLabel priceLabel, totlaPriceLabel;
    String[] bookDatum;

    public DetailPage(String bookId) {
        BookRepository repo = new BookRepository();
        BookData = repo.getBookById(bookId);

        mainPanel.setBackground(Color.PINK);
        detailPanel = new JPanel(grid);
        detailPanel.setBackground(Color.CYAN);
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.ORANGE);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        makegbc(leftPanel, 0, 0, 1, 1);
        makegbc(rightPanel, 1, 0, 1, 1);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        bookDatum = new String[7];
        for (Book book : BookData) {
            if (book.getBookId().equals(bookId)) {
                bookDatum[0] = book.getBookId(); //id
                bookDatum[1] = book.getAuthor(); //저자
                bookDatum[2] = book.getTitle(); //제목
                bookDatum[3] = Integer.toString(book.getPrice()); //가격
                bookDatum[4] = book.getImagePath(); //파일경로
                bookDatum[5] = book.getBookAbstract(); //책 소개
                bookDatum[6] = repo.getAuthorBiographyByBookId(bookId); //저자 소개
                break;
            }
        }
        bookPanel = CreateBookPanels.createSingleBookPanel(bookDatum);
        leftPanel.add(bookPanel[0]);

        String bookAbstract = bookDatum[5];
        String authorAbstract = bookDatum[6];

        titleArea = new JTextArea(bookAbstract);
        titleArea.setFont(new Font("Times NewRoman", Font.PLAIN, 14));
        titleArea.setLineWrap(true);
        titleArea.setWrapStyleWord(true);
        titleArea.setEditable(false);
        JScrollPane titleScroll = new JScrollPane(titleArea);
        titleScroll.setPreferredSize(new Dimension(400, 250));
        titlePanel = new JPanel();
        titlePanel.add(titleScroll);

        authorArea = new JTextArea(authorAbstract);
        authorArea.setFont(new Font("Times NewRoman", Font.PLAIN, 14));
        authorArea.setLineWrap(true);
        authorArea.setWrapStyleWord(true);
        authorArea.setEditable(false);
        JScrollPane authorScroll = new JScrollPane(authorArea);
        authorScroll.setPreferredSize(new Dimension(400, 250));
        authorPanel = new JPanel();
        authorPanel.add(authorScroll);

        rightPanel.add(new JLabel("책 소개"));
        rightPanel.add(titlePanel);
        rightPanel.add(new JLabel("저자 소개"));
        rightPanel.add(authorPanel);

        pricePanel = new JPanel();
        priceLabel = new JLabel();
        priceLabel.setText("가격 : " + bookDatum[3] + " 원 / 권");
        pricePanel.add(priceLabel);
        rightPanel.add(pricePanel);

        QuantitySelector selector = new QuantitySelector();
        int unitprice = Integer.parseInt(bookDatum[3]);
        totalPricePanel = new JPanel();
        totlaPriceLabel = new JLabel();
        totalPricePanel.add(selector.bindTotalPriceLabel(totlaPriceLabel, unitprice));
        rightPanel.add(selector);
        rightPanel.add(totalPricePanel);

        JButton addToCartBtn = new JButton("장바구니에 추가");
        addToCartBtn.addActionListener(e -> {
            int quantity = selector.getQuantity();
            CartController.addToCart(bookDatum[0], quantity);
            JOptionPane.showMessageDialog(null, "장바구니에 추가 되었습니다.");
            selector.setQuantity(1);
        });
        rightPanel.add(addToCartBtn);

        detailPanel.add(leftPanel);
        detailPanel.add(rightPanel);
        mainPanel.add(detailPanel);
    }

    public void makegbc(JComponent c, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;

        grid.setConstraints(c, gbc);
    }

    public JPanel getDetailPage() {
        return basePanel;
    }
}
