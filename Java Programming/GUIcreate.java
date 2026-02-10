import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIcreate{

    public GUIcreate(){

        Frame frame=new Frame("Title");

        Button button=new Button("Click Me");
        button.setBounds(30,30,100,80);

        frame.setSize(500,700);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {

        GUIcreate obj=new GUIcreate();

    }

}