package bookstore.view;

import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;
import bookstore.view.component.QuantitySelector;
import java.awt.*;
import javax.swing.*;

public class DetailPage extends BasePage {

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextArea titleArea, authorArea;
    String[][] BookData = Book.TestBookData;
    JPanel detailPanel, leftPanel, rightPanel, titlePanel, authorPanel, pricePanel, totalPricePanel;
    JPanel[] bookPanel;
    JLabel priceLabel, totlaPriceLabel;
    String[] bookDatum;

    public DetailPage(String bookId) {
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
        for (String[] book : BookData) {
            if (book[0].equals(bookId)) {
                bookDatum[0] = book[0]; //id
                bookDatum[1] = book[1]; //저자
                bookDatum[2] = book[2]; //제목
                bookDatum[3] = book[3]; //가격
                bookDatum[4] = book[4]; //파일경로
                bookDatum[5] = book[5]; //책 소개
                bookDatum[6] = book[6]; //저자 소개
                break;
            }
        }
        bookPanel = CreateBookPanels.createSingleBookPanel(bookDatum);
        leftPanel.add(bookPanel[0]);

        String bookAbstract = bookDatum[5];
        String authorAbstract = bookDatum[6];
        titleArea = new JTextArea(bookAbstract);
        titleArea.setLineWrap(true);
        titleArea.setWrapStyleWord(true);
        titleArea.setEditable(false);
        titleArea.setPreferredSize(new Dimension(400, 200)); // 크기 조정 (너비, 높이)

        titlePanel = new JPanel();
        titlePanel.add(new JScrollPane(titleArea)); // 스크롤 추가

        authorArea = new JTextArea(authorAbstract);
        authorArea.setLineWrap(true);
        authorArea.setWrapStyleWord(true);
        authorArea.setEditable(false);
        authorArea.setPreferredSize(new Dimension(400, 200));

        authorPanel = new JPanel();
        authorPanel.add(new JScrollPane(authorArea));
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
