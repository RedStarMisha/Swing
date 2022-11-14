package filechooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class OpenL implements ActionListener {

    private File f;

    private MainFrame jFrame;

    public OpenL(MainFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser c = new JFileChooser();
        int rVal = c.showOpenDialog(jFrame);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            f = c.getSelectedFile();
            jFrame.setFile(f);
            printFile(f, jFrame);
//            c.getSelectedFile().
//            jFrame.getFileName().setText(c.getSelectedFile().getName());
//            jFrame.getDir().setText(c.getCurrentDirectory().toString());
        }
//        if (rVal == JFileChooser.CANCEL_OPTION) {
//            jFrame.getFileName().setText("canceled");
//            jFrame.getDir().setText("");
//        }
    }
    public void printFile(File f, MainFrame mf) {

        JTextArea t = new JTextArea(10, 15);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                t.setText(line);
            }
            mf.add(t);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
