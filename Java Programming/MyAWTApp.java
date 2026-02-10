import java.awt.*;

public class MyAWTApp {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Container Example");
        Panel panel = new Panel();

        Button button = new Button("Click Me!");
        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
