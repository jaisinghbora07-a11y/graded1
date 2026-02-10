import java.awt.*;
import java.awt.event.*;

public class ChoiceExample {
    public static void main(String[] args) {
        Frame f = new Frame("Choice Example");

        Choice choice = new Choice();
        choice.add("Apple");
        choice.add("Banana");
        choice.add("Mango");

        Label label = new Label("Select a fruit");

        choice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("Selected: " + choice.getSelectedItem());
            }
        });

        f.add(choice);
        f.add(label);

        f.setLayout(new FlowLayout());
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
