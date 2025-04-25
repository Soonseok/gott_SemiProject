package bookstore.view;

import bookstore.controller.CreateBookPanels;
import bookstore.model.BookRepository;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class MainPage extends BasePage{

    JPanel[] bookPanels;
    JPanel latestBookPanel, recommendBookPanel;
    JLabel latestTitleLabel, recommendTitleLabel;
    
    public MainPage() throws HeadlessException {
        BookRepository repo = new BookRepository();
        List<String> recommendIds = List.of("p_28", "p_17", "p_16", "p_29");
        List<String> latestIds = List.of("p_31", "m_0", "b_0", "c_4");
        String[][] recommendBookData = repo.getBooksByIds(recommendIds);
        String[][] latestBookData = repo.getBooksByIds(latestIds);

        mainPanel.setBackground(new Color(255, 95, 162));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        recommendTitleLabel = new JLabel("▼ 추천 도서 ▼");
        recommendTitleLabel.setPreferredSize(new Dimension(400, 50));
        recommendTitleLabel.setMaximumSize(new Dimension(4000, 30));
        recommendTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        recommendBookPanel = new JPanel();
        recommendBookPanel.setLayout(new GridLayout(1, 4, 10, 10));
        bookPanels = CreateBookPanels.createBookPanels(recommendBookData);
        for (int i = 0; i < 4; i++) {
            recommendBookPanel.add(bookPanels[i]);
        }

        latestTitleLabel = new JLabel("▼ 최신 도서 ▼");
        latestTitleLabel.setPreferredSize(new Dimension(400, 50));
        latestTitleLabel.setMaximumSize(new Dimension(4000, 30));
        latestTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        latestBookPanel = new JPanel();
        latestBookPanel.setLayout(new GridLayout(1, 4, 10, 10));
        bookPanels = CreateBookPanels.createBookPanels(latestBookData);
        for (int i = 0; i < 4; i++) {
            latestBookPanel.add(bookPanels[i]);
        }

        mainPanel.add(recommendTitleLabel);
        mainPanel.add(recommendBookPanel);
        mainPanel.add(latestTitleLabel);
        mainPanel.add(latestBookPanel);
    }
    
    public JPanel getMainPanel() {
        return basePanel;
    }
}
