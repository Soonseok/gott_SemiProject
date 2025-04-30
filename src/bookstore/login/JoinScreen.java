package bookstore.login;

import bookstore.controller.DBConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.function.Consumer;
import javax.swing.*;

public class JoinScreen extends JFrame {

    private Consumer<String> onLoginSuccess;
    String choice = null;
    Connection conn = null;

    public JoinScreen(Consumer<String> onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
        setTitle("회원관리 화면");

        // 1. 컴포넌트들을 만들어 보자.
        JLabel title = new JLabel("회원가입", JLabel.CENTER);

        title.setForeground(new Color(0, 0, 0));
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        JButton join = new JButton("회원가입");
        JButton cancel = new JButton("취소");

        JTextField id = new JTextField(10);
        JPasswordField pwd = new JPasswordField(10);
        JTextField name = new JTextField(10);
        JTextField phone = new JTextField(10);

        JRadioButton client = new JRadioButton("고객");
        JRadioButton manager = new JRadioButton("관리자");
        JRadioButton etc = new JRadioButton("기타");

        ButtonGroup bg = new ButtonGroup();
        bg.add(client);
        bg.add(manager);
        bg.add(etc);

        // radio panel
        JPanel radioPanel = new JPanel();
        radioPanel.add(client);
        radioPanel.add(manager);
        radioPanel.add(etc);

        // form panel
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        idPanel.add(new JLabel("아이디 : "));
        idPanel.add(id);

        JPanel pwdPanel = new JPanel();
        pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pwdPanel.add(new JLabel("비밀번호 : "));
        pwdPanel.add(pwd);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        namePanel.add(new JLabel("이    름 : "));
        namePanel.add(name);

        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        phonePanel.add(new JLabel("연 락 처 : "));
        phonePanel.add(phone);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1));
        formPanel.add(idPanel);
        formPanel.add(pwdPanel);
        formPanel.add(namePanel);
        formPanel.add(phonePanel);

        // radio + form panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(radioPanel);
        contentPanel.add(formPanel);

        // button panel
        JPanel panel = new JPanel();
        panel.add(join);
        panel.add(cancel);

        add(title, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setBounds(200, 200, 250, 300);

        setVisible(true);

        cancel.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginScreen(onLoginSuccess);
                dispose();
            }
        }));

        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myId = id.getText();
                String myPw = new String(pwd.getPassword());
                String myName = name.getText();
                String myPhone = phone.getText();

                String salt = PasswordUtil.generateSalt();
                String hashedPw = PasswordUtil.hashPassword(myPw, salt);

                Connection conn = DBConnection.makeConnection();
                String sql = "INSERT INTO userdb (user_id, pw, name, phone, salt) VALUES (?, ?, ?, ?, ?)";

                try {
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, myId);
                    pstmt.setString(2, hashedPw);
                    pstmt.setString(3, myName);
                    pstmt.setString(4, myPhone);
                    pstmt.setString(5, salt);

                    int count = pstmt.executeUpdate();
                    if (count >= 1) {
                        JOptionPane.showMessageDialog(null, "가입 완료!");
                        new loginScreen(onLoginSuccess);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "가입 실패!");
                    }

                    pstmt.close();
                    conn.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "DB 오류: " + e1.getMessage());
                }
            }
        });
    }
}
