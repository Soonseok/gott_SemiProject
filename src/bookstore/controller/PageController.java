package bookstore.controller;

import bookstore.model.*;
import bookstore.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class PageController {

    private static JFrame frame;  // 메인 프레임
    private static Stack<JPanel> pageHistory = new Stack<>(); // 뒤로가기 스택

    public static void initialize(JFrame f) {
        frame = f;
    }

    public static void showMainPage() {
        MainPage mainPage = new MainPage(); // 메인페이지 생성
        setPage(mainPage.getMainPanel());  // 메인페이지를 프레임에 세팅
    }

    public static void showCategoryPage(String categoryName) {
        CategoryPage categoryPage = new CategoryPage(categoryName);
        setPage(categoryPage.getCategoryPage());
    }

    public static void showDetailPage(String bookId) {
        DetailPage detailPage = new DetailPage(bookId);
        setPage(detailPage.getDetailPage());
    }

    public static void showSearchPage(String keyword) {
        SearchPage searchPage = new SearchPage(keyword);
        setPage(searchPage.getSearchPage());
    }

    public static void showCartPage() {
        CartPage cartPage = new CartPage();
        setPage(cartPage.getCartPage());
    }

    public static void setPage(JPanel page) {
        if (frame.getContentPane().getComponentCount() > 0) {
            Component current = frame.getContentPane().getComponent(0);
            if (current instanceof JPanel) {
                pageHistory.push((JPanel) current);
            }
        }
        frame.getContentPane().removeAll();
        frame.getContentPane().add(page);
        frame.revalidate();
        frame.repaint();
    }

    public static void goBack() {
        if (!pageHistory.isEmpty()) {
            JPanel previousPage = pageHistory.pop();
            frame.getContentPane().removeAll();
            frame.getContentPane().add(previousPage);
            frame.revalidate();
            frame.repaint();
        }
    }
}
