package bookstore.login;

import bookstore.controller.CartController;
import bookstore.controller.PageController;
import static bookstore.controller.PageController.previousPageHistory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LoginController {

    private static boolean isLoggedIn = false;
    private static String loggedInUserName = null;

    public static void handleLoginButton(JButton loginBtn) {
        if (isLoggedIn) {
            int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                isLoggedIn = false;
                loggedInUserName = null;
                loginBtn.setText("로그인");
                PageController.showMainPage();
                CartController.clearCart();
                previousPageHistory.pop();
            }
        } else {
            new loginScreen(userName -> {
                isLoggedIn = true;
                loggedInUserName = userName;
                loginBtn.setText(userName);
                try {
                    if (PageController.currentPage.equals("cartPage")) {
                        PageController.showCartPage();
                    } else {
                    }
                } catch (Exception e) {
                }
            });
        }
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public static String getLoggedInUserName() {
        return loggedInUserName;
    }
}
