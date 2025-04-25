package bookstore;

import bookstore.controller.PageController;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Main {

    public static JFrame firstFrame;

    public Main() throws SQLException {
        javax.swing.SwingUtilities.invokeLater(() -> {
            firstFrame = new JFrame("Good Book, Great Book");
            firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            firstFrame.setSize(1200, 900);
            firstFrame.setLocationRelativeTo(null);
            firstFrame.setLayout(new BorderLayout());
            PageController.initialize(firstFrame);  // Controller에 JFrame을 넘김
            PageController.showMainPage();      // 메인페이지 띄우기

            firstFrame.setVisible(true);
        });
        
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println("============START============");
        new Main();
    }
}
