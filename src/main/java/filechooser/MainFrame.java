package filechooser;

import filechooser.OpenL;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainFrame extends JFrame {

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public MainFrame() throws HeadlessException {
        makeMenu();
    }

    private void makeMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m11.addActionListener(new OpenL(this));
        m1.add(m11);
        m1.add(m22);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.setVisible(true);
    }

}
