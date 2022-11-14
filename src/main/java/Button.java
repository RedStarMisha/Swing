import javax.swing.*;
import java.awt.*;

public class Button extends JFrame {
    private final JButton b1 = new JButton();
    private final JButton b2 = new JButton();

    public Button() {
        setLayout(new FlowLayout());
        b1.setText("Кнопка 1");
        b2.setText("Кнопка 2");
        b1.setSize(20, 50);
        b2.setSize(20, 50);
        add(b1);
        add(b2);
    }
}
