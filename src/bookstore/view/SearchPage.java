package bookstore.view;

import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;
import bookstore.model.BookRepository;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

public class SearchPage extends BasePage {
    //String[][] BookData = Book.TestBookData;
    List<Book> BookData;
    JPanel[] bookPanels;
    JPanel searchResultBookPanel;
    JLabel searchResultTitleLabel;

    public SearchPage(String keyword) throws HeadlessException, SQLException {
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        BookRepository repo = new BookRepository();
        BookData = repo.searchBooks(keyword);

        searchResultTitleLabel = new JLabel("검색어 : "+keyword+ "   총 "+ BookData.size()+"권");
        searchResultTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        searchResultTitleLabel.setPreferredSize(new Dimension(400, 50));
        searchResultTitleLabel.setMaximumSize(new Dimension(4000, 30));

        searchResultBookPanel = new JPanel();
        searchResultBookPanel.setLayout(new GridLayout(0, 4, 10, 10));

        bookPanels = CreateBookPanels.createBookPanels(BookData);
        for (int i = 0; i < bookPanels.length; i++) {
            searchResultBookPanel.add(bookPanels[i]);
        }

        // mainPanel.add(searchResultTitleLabel);
        // mainPanel.add(searchResultBookPanel);

        // 스크롤 패널 설정
        JScrollPane scrollPane = new JScrollPane(searchResultBookPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 부드럽게

        // 크기를 mainPanel에 맞춰줌
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(800, 600)); // 이건 화면 크기에 따라 조정

        // mainPanel에 제목 + 스크롤 붙이기
        mainPanel.add(searchResultTitleLabel);
        mainPanel.add(scrollPane);
    }

    public JPanel getSearchPage() {
        return basePanel;
    }
}
