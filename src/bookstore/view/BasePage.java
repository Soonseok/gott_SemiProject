package bookstore.view;

import bookstore.controller.PageController;
import bookstore.login.LoginController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BasePage extends JPanel implements ActionListener {

    JPanel basePanel, mainPanel, topPanel, categoryPanel, searchPanel;
    JButton backBtn, frontBtn, mainBtn, cartBtn, searchBtn, loginBtn;
    JTextField searchTextArea;

    public BasePage() throws HeadlessException {
        setLayout(new BorderLayout());

        basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        mainPanel = new JPanel();
        topPanel = new JPanel();
        searchPanel = new JPanel(new BorderLayout());
        loginBtn = new JButton("로그인");
        loginBtn.addActionListener(e -> LoginController.handleLoginButton(loginBtn));
        backBtn = new JButton("뒤로가기");
        backBtn.addActionListener(e -> PageController.goBack());
        frontBtn = new JButton("앞으로가기");
        frontBtn.addActionListener(e -> PageController.goForward());
        mainBtn = new JButton("메인페이지");
        mainBtn.addActionListener(e -> PageController.showMainPage());
        cartBtn = new JButton("장바구니");
        cartBtn.addActionListener(e -> PageController.showCartPage());
        searchBtn = new JButton("검색");
        searchBtn.addActionListener(e -> PageController.showSearchPage(searchTextArea.getText()));
        searchTextArea = new JTextField(30);
        searchTextArea.addActionListener(e -> PageController.showSearchPage(searchTextArea.getText()));
        searchPanel.add(searchTextArea, BorderLayout.CENTER);
        searchPanel.add(searchBtn, BorderLayout.EAST);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(Color.BLUE);
        topPanel.add(mainBtn);
        topPanel.add(backBtn);
        topPanel.add(frontBtn);
        topPanel.add(searchPanel);
        topPanel.add(cartBtn);
        topPanel.add(loginBtn);
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
            categoryPanel.add(Box.createVerticalStrut(3));
        }

        basePanel.add(topPanel, BorderLayout.NORTH);
        basePanel.add(categoryPanel, BorderLayout.WEST);
        basePanel.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void updateLoginButtonText() {
        if (LoginController.isLoggedIn()) {
            String name = LoginController.getLoggedInUserName();
            loginBtn.setText(name); // 유저 이름
        } else {
            loginBtn.setText("로그인");
        }
    }
}
