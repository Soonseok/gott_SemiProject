package bookstore.controller;

import bookstore.view.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Stack;
import javax.swing.*;

public class PageController {

    private static JFrame frame;  // 메인 프레임
    public static Stack<JPanel> previousPageHistory = new Stack<>(); // 뒤로 가기 스택
    private static Stack<JPanel> forwardPageHistory = new Stack<>(); // 앞으로 가기 스택

    public static void initialize(JFrame f) {
        frame = f;
    }

    public static void showMainPage() {
        MainPage mainPage = new MainPage(); // 메인페이지 생성
        setPage(mainPage.getMainPanel());  // 메인페이지를 프레임에 세팅
    }

    public static void showCategoryPage(String categoryName) {
        try {
            CategoryPage categoryPage = new CategoryPage(categoryName);
            setPage(categoryPage.getCategoryPage());
        } catch (HeadlessException ex) {
        } catch (SQLException ex) {
        }
    }

    public static void showDetailPage(String bookId) {
        DetailPage detailPage = new DetailPage(bookId);
        setPage(detailPage.getDetailPage());
    }

    public static void showSearchPage(String keyword) {
        try {
            SearchPage searchPage = new SearchPage(keyword);
            setPage(searchPage.getSearchPage());
        } catch (HeadlessException ex) {
        } catch (SQLException ex) {
        }
    }
    
    public static void showCartPage() {
        CartPage cartPage = new CartPage();
        setPage(cartPage.getCartPage());
    }

    public static void showPaymentPage(int totalPrice) {
        PaymentPage paymentPage = new PaymentPage(totalPrice);
    }

    public static void setPage(JPanel page) {
        if (frame.getContentPane().getComponentCount() > 0) {
            Component current = frame.getContentPane().getComponent(0);
            if (current instanceof JPanel) {
                previousPageHistory.push((JPanel) current);
            }
        }
        forwardPageHistory.clear(); // 앞으로가기 스택 초기화
        frame.getContentPane().removeAll();
        frame.getContentPane().add(page);
        frame.revalidate();
        frame.repaint();
    }

    public static void goBack() {
        if (!previousPageHistory.isEmpty()) {
            Component current = frame.getContentPane().getComponent(0);
            if (current instanceof JPanel) {
                forwardPageHistory.push((JPanel) current); // 현재 페이지를 앞으로 가기 스택에 저장
            }

            JPanel previousPage = previousPageHistory.pop();
            System.out.println("뒤로 가기 누름");
            frame.getContentPane().removeAll();
            frame.getContentPane().add(previousPage);
            frame.revalidate();
            frame.repaint();
        }
    }

    public static void goForward() {
        if (!forwardPageHistory.isEmpty()) {
            Component current = frame.getContentPane().getComponent(0);
            if (current instanceof JPanel) {
                previousPageHistory.push((JPanel) current); // 현재 페이지를 뒤로가기 스택에 저장
            }

            JPanel nextPage = forwardPageHistory.pop();
            System.out.println("앞으로 가기 누름");
            frame.getContentPane().removeAll();
            frame.getContentPane().add(nextPage);
            frame.revalidate();
            frame.repaint();
        }
    }

}
