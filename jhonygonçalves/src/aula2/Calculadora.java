import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton[] buttons;
    private String[] buttonTexts = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
    private double number1, number2, result;
    private String operator;
    private boolean isDecimal = false;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttons = new JButton[16];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonTexts[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(new Color(69, 90, 100));
            buttonPanel.add(buttons[i]);
        }

        JPanel resetPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton resetButton = new JButton("C");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                operator = null;
                isDecimal = false;
            }
        });
        resetButton.setFont(new Font("Arial", Font.PLAIN, 24));
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(new Color(217, 30, 24));
        resetButton.setPreferredSize(new Dimension(50, 50));
        resetPanel.add(resetButton);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputField, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(resetPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora();
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                String buttonText = buttons[i].getText();

                if (buttonText.matches("[0-9]")) {
                    inputField.setText(inputField.getText() + buttonText);
                } else if (buttonText.equals(".")) {
                    if (!isDecimal) {
                        inputField.setText(inputField.getText() + buttonText);
                        isDecimal = true;
                    }
                } else if (buttonText.matches("[/*\\-+]")) {
                    if (operator == null) {
                        number1 = Double.parseDouble(inputField.getText());
                        operator = buttonText;
                        inputField.setText("");
                        isDecimal = false;
                    } else {
                        number2 = Double.parseDouble(inputField.getText());
                        calculate();
                        number1 = result;
                        operator = buttonText;
                        inputField.setText("");
                        isDecimal = false;
                    }
                } else if (buttonText.equals("=")) {
                    number2 = Double.parseDouble(inputField.getText());
                    calculate();
                    inputField.setText(String.valueOf(result));
                    operator = null;
                    isDecimal = false;
                }
            }
        }
    }

    private void calculate() {
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
    }
}

