import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TextArea extends JFrame {
    private final JButton b1 = new JButton();
    private final JButton b2 = new JButton();
    private JTextArea t = new JTextArea(20, 40);
    private Map<String, String> m;

    public TextArea() throws HeadlessException {
        b1.setSize(20, 40);
        b2.setSize(20, 40);
        m = Map.of(
                "Сша", "Вашингтон",
                "Россия", "Москва"
        );
        b1.addActionListener(e -> {
            for (Map.Entry me: m.entrySet()) {
                t.append(me.getKey() + ": " + me.getValue() + "\n");
            }
        });

        b2.addActionListener(e -> {
            t.setText("");
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(b1);
        add(b2);
    }
}
