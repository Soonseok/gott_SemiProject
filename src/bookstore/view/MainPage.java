package bookstore.view;

import java.awt.*;
import javax.swing.*;
import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;

public class MainPage extends BasePage{

    JPanel[] bookPanels;
    JPanel recentBookPanel, recommendBookPanel;
    JLabel recentTitleLabel, recommendTitleLabel;
    String[][] recommendBookData = Book.TestBookData;

    public MainPage() throws HeadlessException {
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        recentTitleLabel = new JLabel("▼ 최신 도서 ▼");
        recentTitleLabel.setPreferredSize(new Dimension(400, 50));
        recentTitleLabel.setMaximumSize(new Dimension(4000, 30));  // 늘어나지 않게
        recommendTitleLabel = new JLabel("▼ 추천 도서 ▼");
        recommendTitleLabel.setPreferredSize(new Dimension(400, 50));
        recommendTitleLabel.setMaximumSize(new Dimension(4000, 30));  // 늘어나지 않게
        recentBookPanel = new JPanel();
        recentBookPanel.setLayout(new GridLayout(1, 4, 10, 10));
        bookPanels = CreateBookPanels.createBookPanels(recommendBookData);
        for (int i = 0; i < 4; i++) {
            recentBookPanel.add(bookPanels[i]);
        }

        recommendBookPanel = new JPanel();
        recommendBookPanel.setLayout(new GridLayout(1, 4, 10, 10));
        bookPanels = CreateBookPanels.createBookPanels(recommendBookData);
        for (int i = 0; i < 4; i++) {
            recommendBookPanel.add(bookPanels[i]);
        }
        
        mainPanel.add(recentTitleLabel);
        mainPanel.add(recentBookPanel);
        mainPanel.add(recommendTitleLabel);
        mainPanel.add(recommendBookPanel);
    }
    
    public JPanel getMainPanel() {
        return basePanel;
    }
}
