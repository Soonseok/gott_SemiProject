package bookstore.controller;

import bookstore.model.Book;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;

public class CreateBookPanels {

    public static JPanel[] createBookPanels(List<Book> bookList) {
        JPanel[] bookPanels = new JPanel[bookList.size()];

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            JPanel bookPanel = new JPanel();
            //bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
            bookPanel.setPreferredSize(new Dimension(150, 400)); // 가로는 고정, 세로는 내용에 따라 유동적
            bookPanel.setMaximumSize(new Dimension(150, Integer.MAX_VALUE));
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

            // 표지 썸네일
            JLabel imgLabel = new JLabel();
            ImageIcon originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\" + book.getImagePath());
            if (originalIcon.getImageLoadStatus() != 8) {
                originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\_default.jpg");
            }
            Image originalImg = originalIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            imgLabel.setIcon(resizedIcon);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 책 제목
            // JLabel titleLabel = new JLabel(book.getTitle());
            // titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
            // titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            String title = book.getTitle();
            String htmlTitle = "<html><div style='text-align: center; width: 200px;'>" + title + "</div></html>";
            JLabel titleLabel = new JLabel(htmlTitle);
            titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 저자
            JLabel authorLabel = new JLabel(book.getAuthor());
            authorLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel emptyLabel = new JLabel("     ");
            emptyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            bookPanel.add(emptyLabel);

            bookPanel.add(imgLabel);
            bookPanel.add(Box.createVerticalStrut(10)); // 약간 간격 주기
            bookPanel.add(titleLabel);
            bookPanel.add(authorLabel);

            bookPanel.setBackground(new Color(252, 200, 155)); // 색 변동

            bookPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked: " + book.getBookId());
                    // 여기에 DetailPage로 이동하는 코드 추가
                    PageController.showDetailPage(book.getBookId());
                }
            });

            bookPanels[i] = bookPanel;
        }

        return bookPanels;
    }

    public static JPanel[] createBookPanels(String[][] arr) {
        JPanel[] bookPanels = new JPanel[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String author = arr[i][1];
            String title = arr[i][2];
            String imgPath = arr[i][4];

            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

            // 표지 썸네일
            JLabel imgLabel = new JLabel();
            ImageIcon originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\" + imgPath);
            if (originalIcon.getImageLoadStatus() != 8) {
                originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\_default.jpg");
            }
            Image originalImg = originalIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            imgLabel.setIcon(resizedIcon);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 책 제목
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 저자
            JLabel authorLabel = new JLabel(author);
            authorLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel emptyLabel = new JLabel("     ");
            emptyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            bookPanel.add(emptyLabel);

            bookPanel.add(imgLabel);
            bookPanel.add(Box.createVerticalStrut(10)); // 약간 간격 주기
            bookPanel.add(titleLabel);
            bookPanel.add(authorLabel);

            bookPanel.setBackground(new Color(252, 200, 155)); // 색 변동

            String bookId = arr[i][0];
            bookPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked: " + bookId);
                    // 여기에 DetailPage로 이동하는 코드 추가
                    PageController.showDetailPage(bookId);
                }
            });

            bookPanels[i] = bookPanel;

        }
        return bookPanels;
    }

    public static JPanel[] createSingleBookPanel(List<Book> bookList) {
        JPanel[] bookPanels = new JPanel[4];
        Book book = bookList.get(0);
        for (int i = 0; i < bookPanels.length; i++) {
            String bookId = book.getBookId();
            String author = book.getAuthor();
            String title = book.getTitle();
            String imgPath = book.getImagePath();

            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

            // 표지 썸네일
            JLabel imgLabel = new JLabel();
            ImageIcon originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\" + imgPath);
            if (originalIcon.getImageLoadStatus() != 8) {
                originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\_default.jpg");
            }
            Image originalImg = originalIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            imgLabel.setIcon(resizedIcon);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 책 제목
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 저자
            JLabel authorLabel = new JLabel(author);
            authorLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
            authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel emptyLabel = new JLabel("     ");
            emptyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            bookPanel.add(emptyLabel);

            bookPanel.add(imgLabel);
            bookPanel.add(Box.createVerticalStrut(10)); // 약간 간격 주기
            bookPanel.add(titleLabel);
            bookPanel.add(authorLabel);

            bookPanel.setBackground(new Color(252, 200, 155)); // 색 변동

            bookPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked: " + bookId);
                    // 여기에 DetailPage로 이동하는 코드 추가
                    PageController.showDetailPage(bookId);
                }
            });

            bookPanels[i] = bookPanel;

        }
        return bookPanels;
    }

    public static JPanel[] createSingleBookPanel(String[] arr) {
        JPanel[] bookPanels = new JPanel[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String author = arr[1];
            String title = arr[2];
            String imgPath = arr[4];

            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

            // 표지 썸네일
            JLabel imgLabel = new JLabel();
            ImageIcon originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\" + imgPath);
            if (originalIcon.getImageLoadStatus() != 8) {
                originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\_default.jpg");
            }
            Image originalImg = originalIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            imgLabel.setIcon(resizedIcon);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 책 제목
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 저자
            JLabel authorLabel = new JLabel(author);
            authorLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
            authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel emptyLabel = new JLabel("     ");
            emptyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            bookPanel.add(emptyLabel);

            bookPanel.add(imgLabel);
            bookPanel.add(Box.createVerticalStrut(10)); // 약간 간격 주기
            bookPanel.add(titleLabel);
            bookPanel.add(authorLabel);

            bookPanel.setBackground(new Color(252, 200, 155)); // 색 변동

            String bookId = arr[0];
            bookPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked: " + bookId);
                    // 여기에 DetailPage로 이동하는 코드 추가
                    PageController.showDetailPage(bookId);
                }
            });

            bookPanels[i] = bookPanel;

        }
        return bookPanels;
    }

    public static JPanel[] createSingleBookPanelX(String[] arr) {
        JPanel[] bookPanels = new JPanel[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String author = arr[1];
            String title = arr[2];
            String price = arr[3];
            String imgPath = arr[4];

            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.X_AXIS));
            bookPanel.setMaximumSize(new Dimension(800, 250)); // 최대 가로 크기 지정
            bookPanel.setPreferredSize(new Dimension(800, 250)); // 선호 크기 지정

            // 표지 썸네일
            JLabel imgLabel = new JLabel();
            ImageIcon originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\" + imgPath);
            if (originalIcon.getImageLoadStatus() != 8) {
                originalIcon = new ImageIcon("C:\\java2025\\java_home\\SemiProject\\coverImages\\_default.jpg");
            }
            Image originalImg = originalIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            imgLabel.setIcon(resizedIcon);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 책 제목
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 저자
            JLabel authorLabel = new JLabel(author);
            authorLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
            authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 가격
            JLabel priceLabel = new JLabel(price+" 원");
            priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.add(titleLabel);
            textPanel.add(authorLabel);
            textPanel.setOpaque(false); // 배경 투명

            JPanel pricePanel = new JPanel();
            pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.Y_AXIS));
            pricePanel.add(priceLabel);
            pricePanel.setOpaque(false);

            bookPanel.add(Box.createRigidArea(new Dimension(20, 0))); // 왼쪽 여백
            bookPanel.add(imgLabel);
            bookPanel.add(Box.createRigidArea(new Dimension(50, 0))); // 이미지와 텍스트 간 간격
            bookPanel.add(textPanel);
            bookPanel.add(Box.createRigidArea(new Dimension(50, 0)));
            bookPanel.add(pricePanel);

            bookPanel.setBackground(new Color(252, 200, 155)); // 색 변동

            String bookId = arr[0];
            bookPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked: " + bookId);
                    // 여기에 DetailPage로 이동하는 코드 추가
                    PageController.showDetailPage(bookId);
                }
            });

            bookPanels[i] = bookPanel;

        }
        return bookPanels;
    }
}
