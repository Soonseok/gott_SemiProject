package bookstore.view.component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuantitySelector extends JPanel {

    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 999;

    private JButton minusButton;
    private JButton plusButton;
    private JTextField quantityField;
    private JLabel targetLabel;
    private int unitPrice = 0;
    private int quantity = 1;

    public QuantitySelector() {
        initComponents();
        layoutComponents();
        registerListeners();
    }

    private void initComponents() {
        minusButton = new JButton("-");
        plusButton = new JButton("+");
        quantityField = new JTextField("1", 3);
        quantityField.setHorizontalAlignment(JTextField.CENTER);
    }

    private void layoutComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        add(minusButton);
        add(quantityField);
        add(plusButton);
    }

    private void registerListeners() {
        minusButton.addActionListener(e -> {
            if (quantity > 1) {
                quantity--;
                quantityField.setText(String.valueOf(quantity));
                updateLabel();
            }
        });

        plusButton.addActionListener(e -> {
            if (quantity < MAX_QUANTITY) {
                quantity++;
                quantityField.setText(String.valueOf(quantity));
                updateLabel();
            }
        });

        // 엔터 입력 시
        quantityField.addActionListener(e -> {
            try {
                int newQuantity = Integer.parseInt(quantityField.getText());
                quantity = validateQuantity(newQuantity);
                updateLabel();
            } catch (NumberFormatException ignored) {
                // 잘못된 값이면 1로
                quantity = MIN_QUANTITY;
                updateLabel();
            }
        });

        // 포커스 잃었을 때
        quantityField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validateQuantity(quantity);
            }
        });
    }

    private int validateQuantity(int value) {
        try {
            value = Integer.parseInt(quantityField.getText().trim());
            if (value < MIN_QUANTITY) {
                value = MIN_QUANTITY;
            }
            if (value > MAX_QUANTITY) {
                value = MAX_QUANTITY;
            }
            setQuantity(value);
        } catch (NumberFormatException e) {
            setQuantity(MIN_QUANTITY);
        }
        return value;
    }

    public int getQuantity() {
        try {
            return Integer.parseInt(quantityField.getText().trim());
        } catch (NumberFormatException e) {
            return MIN_QUANTITY;
        }
    }

    public void setQuantity(int quantity) {
        quantityField.setText(String.valueOf(quantity));
    }

    public JLabel bindTotalPriceLabel(JLabel label, int pricePerUnit) {
        this.targetLabel = label;
        this.unitPrice = pricePerUnit;
        updateLabel();
        return targetLabel;
    }

    private void updateLabel() {
        if (targetLabel != null) {
            int total = quantity * unitPrice;
            targetLabel.setText("총 " + total + "원");
        }
    }
}
