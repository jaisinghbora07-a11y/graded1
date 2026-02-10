import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Calculator {
    public Calculator(){
        JFrame f=new JFrame();
        JLabel j=new JLabel("Simple Calculator");
        JPanel p=new JPanel();
        p.setBackground(Color.GRAY);


        JTextArea j1=new JTextArea();
        j1.setBounds(100,100,100,50);

        JTextArea j2=new JTextArea();
        j2.setBounds(100,150,100,50);

        JButton b=new JButton("+");
        











        p.add(j1);
        p.add(j2);




        f.add(p,BorderLayout.CENTER);
        f.add(j,BorderLayout.SOUTH);
        f.setBackground(Color.WHITE);
        f.setSize(500,600);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator obj=new Calculator();
    }

}
