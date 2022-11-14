package filechooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FileChooserTest extends JFrame {
    private JTextField fileName = new JTextField();
    private JTextField dir = new JTextField();
    private JButton open = new JButton();

    private JButton save = new JButton();
    public FileChooserTest() {
        open.setSize(50, 50);
        save.setSize(20, 50);
        JPanel p = new JPanel();
        p.setSize(100, 100);
        open.addActionListener(new ColorChooser(this));
//        open.addActionListener(new OpenL(this));
        p.add(open);
        add(p, BorderLayout.SOUTH);
//        dir.setEditable(false);
//        fileName.setEditable(false);
//        p = new JPanel();
//        p.setLayout(new GridLayout(2, 1));
//        p.add(fileName);
//        p.add(dir);
//        add(p, BorderLayout.NORTH);

//        dir.setEditable(false);
//        fileName.setEditable(false);

    }
    public JTextField getDir() {
        return dir;
    }

    public JTextField getFileName() {
        return fileName;
    }

}
