package bookstore.view;

import bookstore.controller.CreateBookPanels;
import bookstore.controller.PageController;
import bookstore.model.Book;
import bookstore.model.BookRepository;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

public class CategoryPage extends BasePage {

    //String[][] BookData = Book.TestBookData;
    List<Book> BookData;
    JPanel[] bookPanels;
    JPanel categoryBookPanel;
    JLabel categoryTitleLabel;

    public CategoryPage(String categoryName) throws HeadlessException, SQLException {
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        BookRepository repo = new BookRepository();
        switch (categoryName) {
            case "All" ->
                BookData = repo.getAllBooks();
            case "Physics" ->
                BookData = repo.getBooksByCategory("p");
            case "Mathematics" ->
                BookData = repo.getBooksByCategory("m");
            case "Chemistry" ->
                BookData = repo.getBooksByCategory("c");
            case "Biology" ->
                BookData = repo.getBooksByCategory("b");
        }
        
        categoryTitleLabel = new JLabel("분류 : "+categoryName+ "   총 "+ BookData.size()+"권");
        categoryTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        categoryTitleLabel.setPreferredSize(new Dimension(400, 50));
        categoryTitleLabel.setMaximumSize(new Dimension(4000, 30));

        categoryBookPanel = new JPanel();
        categoryBookPanel.setLayout(new GridLayout(0, 4, 10, 10));

        bookPanels = CreateBookPanels.createBookPanels(BookData);
        for (int i = 0; i < bookPanels.length; i++) {
            final int index = i;
            categoryBookPanel.add(bookPanels[i]);
            bookPanels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    Book clickedBook = BookData.get(index);
                    String bookId = clickedBook.getBookId();
                    PageController.showDetailPage(bookId);
                    System.out.println(bookId);
                }
            });
        }
        // mainPanel.add(categoryTitleLabel);
        // mainPanel.add(categoryBookPanel);

        // 스크롤 패널 설정
        JScrollPane scrollPane = new JScrollPane(categoryBookPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 부드럽게

        // 크기를 mainPanel에 맞춰줌
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(800, 600)); // 이건 화면 크기에 따라 조정

        // mainPanel에 제목 + 스크롤 붙이기
        mainPanel.add(categoryTitleLabel);
        mainPanel.add(scrollPane);

    }

    public JPanel getCategoryPage() {
        return basePanel;
    }
}
