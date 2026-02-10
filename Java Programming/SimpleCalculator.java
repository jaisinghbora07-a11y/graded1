import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    // Components
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton, clearButton;

    public SimpleCalculator() {
        // Frame title
        setTitle("Simple Calculator");

        // Set layout
        setLayout(new GridLayout(5, 2, 10, 10));

        // Initialize components
        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clearButton = new JButton("Clear");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to frame
        add(num1Label);
        add(num1Field);

        add(num2Label);
        add(num2Field);

        add(resultLabel);
        add(resultField);

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(clearButton);

        // Frame settings
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1, num2, result = 0;

        try {
            num1 = Double.parseDouble(num1Field.getText());
            num2 = Double.parseDouble(num2Field.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
            return;
        }

        if (e.getSource() == addButton) {
            result = num1 + num2;
        } else if (e.getSource() == subButton) {
            result = num1 - num2;
        } else if (e.getSource() == mulButton) {
            result = num1 * num2;
        } else if (e.getSource() == divButton) {
            if (num2 == 0) {
                JOptionPane.showMessageDialog(this, "Error: Division by zero");
                return;
            }
            result = num1 / num2;
        } else if (e.getSource() == clearButton) {
            num1Field.setText("");
            num2Field.setText("");
            resultField.setText("");
            return;
        }

        resultField.setText(String.valueOf(result));
    }

    // Main method
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
