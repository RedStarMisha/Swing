import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Перехват событий кнопкой
 */

public class Button2 extends JFrame {
    private final JButton b1 = new JButton();
    private final JButton b2 = new JButton();
    private JTextField txt = new JTextField(10);
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            txt.setText(name);
        }
    }
    private ButtonListener listener = new ButtonListener();

    public Button2() {
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        setLayout(new FlowLayout());
        b1.setText("Кнопка 1");
        b2.setText("Кнопка 2");
        b1.setSize(20, 50);
        b2.setSize(20, 50);
        add(b1);
        add(b2);
        add(txt);
    }
}
