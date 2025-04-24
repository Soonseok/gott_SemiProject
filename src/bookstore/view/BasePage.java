package bookstore.view;

import bookstore.controller.PageController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BasePage extends JPanel implements ActionListener {
    
    JPanel basePanel, mainPanel, topPanel, categoryPanel, searchPanel;
    JButton backBtn, frontBtn, mainBtn, cartBtn, searchBtn;
    JTextField searchTextArea;

    public BasePage() throws HeadlessException {
        setLayout(new BorderLayout());

        basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        mainPanel = new JPanel();
        topPanel = new JPanel();
        searchPanel = new JPanel(new GridLayout(1, 2));
        backBtn = new JButton("뒤");
        frontBtn = new JButton("앞");
        mainBtn = new JButton("홈");
        mainBtn.addActionListener(e -> PageController.showMainPage());
        cartBtn = new JButton("장");
        cartBtn.addActionListener(e -> PageController.showCartPage());
        searchBtn = new JButton("검");
        searchTextArea = new JTextField(30);
        searchTextArea.addActionListener(e -> PageController.showSearchPage(searchTextArea.getText()));
        searchBtn.addActionListener(e -> PageController.showSearchPage(searchTextArea.getText()));
        searchPanel.add(searchTextArea);
        searchPanel.add(searchBtn);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Color.BLUE);
        topPanel.add(mainBtn);
        topPanel.add(backBtn);
        topPanel.add(frontBtn);
        topPanel.add(searchPanel);
        topPanel.add(cartBtn);
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        categoryPanel.setBackground(Color.RED);
        String[] categories = {"All", "Physics", "Mathematics", "Chemistry", "Biology"};
        for (String category : categories) {
            JButton button = new JButton(category);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(200, 50));
            button.addActionListener(e -> PageController.showCategoryPage(category));
            categoryPanel.add(button);
        }
        
        basePanel.add(topPanel, BorderLayout.NORTH);
        basePanel.add(categoryPanel, BorderLayout.WEST);
        basePanel.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
