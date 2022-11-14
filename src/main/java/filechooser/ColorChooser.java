package filechooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooser implements ActionListener {

    private FileChooserTest jFrame;

    public ColorChooser(FileChooserTest jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label = new JLabel();
        label = new JLabel("Welcome to GeeksforGeeks",
                JLabel.CENTER);

        // set the foreground color of the text
        label.setForeground(Color.green);

        // set background color of the field
        label.setBackground(Color.WHITE);
        label.setOpaque(true);

        // set font type and size of the text
        label.setFont(new Font("SansSerif", Font.BOLD, 30));

        // set size of the label
        label.setPreferredSize(new Dimension(100, 65));

        // create a Panel and set its layout
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(label, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Label"));

        // Set up color chooser for setting text color
        JColorChooser Jcc = new JColorChooser(label.getForeground());
        Jcc.setBorder(BorderFactory.createTitledBorder(
                "Choose Text Color"));

        jFrame.add(bannerPanel, BorderLayout.CENTER);
        jFrame.add(Jcc, BorderLayout.PAGE_END);
        label.setForeground(Color.BLUE);
//        JColorChooser c = new JColorChooser(label.getForeground());
//        jFrame.add(c);
//        int rVal = c.showOpenDialog(jFrame);
//        if (rVal == JFileChooser.APPROVE_OPTION) {
//            jFrame.getFileName().setText(c.getSelectedFile().getName());
//            jFrame.getDir().setText(c.getCurrentDirectory().toString());
//        }
//        if (rVal == JFileChooser.CANCEL_OPTION) {
//            jFrame.getFileName().setText("canceled");
//            jFrame.getDir().setText("");
//        }
    }


}
