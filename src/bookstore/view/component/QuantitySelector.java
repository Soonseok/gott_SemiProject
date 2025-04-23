package bookstore.view.component;

import javax.swing.*;

public class QuantitySelector extends JPanel{
    private JButton minusButton, plusButton;
    private JTextField quantityField;

    private int quantity = 1;
    private final int MIN_QUANTITY = 1;
    private final int MAX_QUANTITY = 999;

    public QuantitySelector() {
        initComponents();
        layoutComponents();
        registerListeners();
    }
    
    private void initComponents() {
        // 버튼과 필드 생성

    }

    private void layoutComponents() {
        // 패널 안에 버튼과 필드 배치
    }

    private void registerListeners() {
        // 버튼 클릭, 텍스트 입력 이벤트 설정
    }

    // 외부에서 수량을 읽거나 설정할 수 있게 메서드 제공
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { /* 유효성 검사하고 설정 */ }
}
