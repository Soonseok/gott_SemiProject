package bookstore.view;

import bookstore.controller.CartController;
import bookstore.controller.PageController;
import static bookstore.controller.PageController.previousPageHistory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaymentPage extends JFrame implements ActionListener {

    JLabel priceLabel;
    JButton[] buttons = new JButton[12];
    JButton[] nbuttons = new JButton[6];
    JButton confirmBtn;
    String[] texts = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "지우기", "0", ""};
    JPanel mainPanel, txtPanel, numPanel, buttonPanel;
    int cnt = 0;

    public PaymentPage(int totalPrice) throws HeadlessException {
        mainPanel = new JPanel();
        setSize(300, 600);
        setTitle("결제창");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        txtPanel = new JPanel();
        numPanel = new JPanel();
        numPanel.setLayout(new BoxLayout(numPanel, BoxLayout.X_AXIS));
        buttonPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(texts[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }
        for (int i = 0; i < nbuttons.length; i++) {
            nbuttons[i] = new JButton();
            nbuttons[i].setPreferredSize(new Dimension(30, 30));
            nbuttons[i].setEnabled(false);
            nbuttons[i].setBackground(new Color(10 * i, 20 * i, 30 * i));
            nbuttons[i].addActionListener(this);
            numPanel.add(nbuttons[i]);
        }
        confirmBtn = new JButton();
        confirmBtn.setText("확인");
        confirmBtn.setEnabled(false);
        confirmBtn.addActionListener(this);

        txtPanel.setBackground(Color.YELLOW);
        numPanel.setBackground(Color.BLACK);

        priceLabel = new JLabel();
        priceLabel.setText("총 결제 예정 금액 : "+totalPrice+" 원");

        txtPanel.add(priceLabel);

        mainPanel.add(txtPanel);
        mainPanel.add(numPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(confirmBtn);
        add(mainPanel);

        setVisible(true);
    }

    public void getPaymentPage(int totalPrice) {
        new PaymentPage(totalPrice);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.matches("\\d")) {
            System.out.println("숫자 버튼 눌림: " + cmd);
            cnt ++;
            if(cnt == 6){
                confirmBtn.setEnabled(true);
            }
        } else {
            System.out.println("숫자가 아닌 버튼 눌림: " + cmd);
            if(cmd.equals("")){}
            else if (cmd.equals("지우기")){
                cnt = 0;
            }
        }
        if (cmd.equals("확인")) {
            JOptionPane.showMessageDialog(null, "결제 완료");
            dispose();
            CartController.clearCart();
            PageController.showMainPage();
            previousPageHistory.pop();
        }
    }
}
