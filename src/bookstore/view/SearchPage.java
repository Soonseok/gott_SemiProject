package bookstore.view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;

public class SearchPage extends BasePage {

    String[][] BookData = Book.TestBookData;
    JPanel[] bookPanels;
    JPanel searchResultBookPanel;
    JLabel searchResultTitleLabel;

    public SearchPage(String keyword) throws HeadlessException {
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        searchResultTitleLabel = new JLabel(keyword);
        searchResultTitleLabel.setPreferredSize(new Dimension(400, 50));
        searchResultTitleLabel.setMaximumSize(new Dimension(4000, 30));
        searchResultBookPanel = new JPanel();
        searchResultBookPanel.setLayout(new GridLayout(0, 4, 10, 10));
        String[][] resultData = new String[BookData.length][3];
        int index = 0;
        for (int i = 0; i < BookData.length; i++) {
            if (BookData[i][1].equals(keyword)) {
                resultData[index] = BookData[i];
                index++;
            }
        }
        resultData = Arrays.copyOf(resultData, index);
        bookPanels = CreateBookPanels.createBookPanels(resultData);
        for (int i = 0; i < bookPanels.length; i++) {
            searchResultBookPanel.add(bookPanels[i]);
        }

        mainPanel.add(searchResultTitleLabel);
        mainPanel.add(searchResultBookPanel);
    }

    public JPanel getSearchPage() {
        return basePanel;
    }
}
