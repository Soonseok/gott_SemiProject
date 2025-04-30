package bookstore.login;

import bookstore.controller.DBConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import javax.swing.*;

public class loginScreen extends JFrame {

    public interface LoginCallback {

        void onLogin(String userId);
    }

    JTextField jtf1 = null;
    private String userName;

    public loginScreen(Consumer<String> onLoginSuccess) throws HeadlessException {

        setTitle("좋책위책");

        JPanel title = new JPanel();
        JLabel login = new JLabel("로그인");
        login.setForeground(new Color(0, 0, 0));
        login.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        title.add(login);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(3, 2));

        JPanel idPanel
                = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jlb1 = new JLabel("아이디 : ", JLabel.CENTER);

        idPanel.add(jlb1);

        JPanel idPanel2
                = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jtf1 = new JTextField(10);

        idPanel2.add(jtf1);

        jp1.add(idPanel);
        jp1.add(idPanel2);

        JPanel pwdPanel
                = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jlb2 = new JLabel("비밀번호 : ", JLabel.CENTER);
        JPanel pwdPanel2
                = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPasswordField jtf2 = new JPasswordField(10);

        pwdPanel.add(jlb2);
        pwdPanel2.add(jtf2);

        jp1.add(pwdPanel);
        jp1.add(pwdPanel2);

        JPanel loginPanel
                = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jLogin = new JButton("로그인");
        jLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("로긴로긴");
                String inputId = jtf1.getText();
                String inputPw = new String(jtf2.getPassword());

                Connection conn = DBConnection.makeConnection();
                String query = "SELECT pw, salt FROM userdb WHERE user_id = ?";
                try {
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, inputId);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        String storedHash = rs.getString("pw");
                        String storedSalt = rs.getString("salt");

                        String hashedInput = PasswordUtil.hashPassword(inputPw, storedSalt);

                        if (storedHash.equals(hashedInput)) {
                            System.out.println("로그인 성공");
                            onLoginSuccess.accept(inputId); // 로그인 성공 콜백
                            LoginController login = new LoginController();
                            login.setLoggedIn(true);
                            System.out.println(login.isLoggedIn());
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
                    }
                    rs.close();
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JPanel joinPanel
                = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton join = new JButton("회원가입");
        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("횐갑횐갑");
                new JoinScreen(onLoginSuccess);
                dispose();
            }
        });

        loginPanel.add(jLogin);
        joinPanel.add(join);
        jp1.add(loginPanel);
        jp1.add(joinPanel);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout());
        jp2.add(jp1);

        setLayout(new BorderLayout());

        add(title, BorderLayout.NORTH);
        add(jp2, BorderLayout.CENTER);

        setBounds(200, 200, 300, 250);

        setResizable(false);

        setVisible(true);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
