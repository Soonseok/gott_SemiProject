package bookstore;

import bookstore.controller.PageController;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Main {

    public static JFrame firstFrame;

    public Main() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            firstFrame = new JFrame("Good Book, Great Book");
            firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            firstFrame.setSize(1200, 850);
            firstFrame.setLocationRelativeTo(null);
            firstFrame.setLayout(new BorderLayout());
            PageController.initialize(firstFrame);  // Controller에 JFrame을 넘김
            PageController.showMainPage();      // 메인페이지 띄우기

            firstFrame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
