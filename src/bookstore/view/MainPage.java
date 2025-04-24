package bookstore.view;

import bookstore.controller.CreateBookPanels;
import bookstore.model.Book;
import java.awt.*;
import javax.swing.*;

public class MainPage extends BasePage{

    JPanel[] bookPanels;
    JPanel recentBookPanel, recommendBookPanel;
    JLabel recentTitleLabel, recommendTitleLabel;
    String[][] recommendBookData = Book.TestBookData;

    public MainPage() throws HeadlessException {
        mainPanel.setBackground(new Color(255, 95, 162));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        recentTitleLabel = new JLabel("▼ 최신 도서 ▼");
        recentTitleLabel.setPreferredSize(new Dimension(400, 50));
        recentTitleLabel.setMaximumSize(new Dimension(4000, 30));  // 늘어나지 않게
        recentTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        recommendTitleLabel = new JLabel("▼ 추천 도서 ▼");
        recommendTitleLabel.setPreferredSize(new Dimension(400, 50));
        recommendTitleLabel.setMaximumSize(new Dimension(4000, 30));  // 늘어나지 않게
        recommendTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
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
