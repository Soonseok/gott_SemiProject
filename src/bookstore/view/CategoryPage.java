package bookstore.view;

import java.awt.*;
import javax.swing.*;
import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;

public class CategoryPage extends BasePage{
    String[][] BookData = Book.TestBookData;
    JPanel[] bookPanels;
    JPanel categoryBookPanel;
    JLabel categoryTitleLabel;

    public CategoryPage(String categoryName)  throws HeadlessException{
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        categoryTitleLabel = new JLabel(categoryName);
        categoryTitleLabel.setPreferredSize(new Dimension(400, 50));
        categoryTitleLabel.setMaximumSize(new Dimension(4000, 30));
        categoryBookPanel = new JPanel();
        categoryBookPanel.setLayout(new GridLayout(0, 4, 10, 10));
        bookPanels = CreateBookPanels.createBookPanels(BookData);
        for (int i = 0; i < bookPanels.length; i++) {
            categoryBookPanel.add(bookPanels[i]);
        }
        mainPanel.add(categoryTitleLabel);
        mainPanel.add(categoryBookPanel);
    }

    public JPanel getCategoryPage() {
        return basePanel;
    }
}
