
import filechooser.MainFrame;

import javax.swing.*;

public class Main extends JFrame {

    static Main mm;
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Helper.run(mainFrame, 400, 400);
//        mainFrame.printFile();
    }
}
