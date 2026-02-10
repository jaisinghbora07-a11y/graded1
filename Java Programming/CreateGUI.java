import java.awt.*;
import java.awt.event.WindowAdapter;

public class CreateGUI {
    
    public CreateGUI(){

        Frame frame=new Frame("New Frame");

        frame.setSize(400,500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        CreateGUI obj=new CreateGUI();
    }

}
