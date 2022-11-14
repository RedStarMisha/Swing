import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application implements ActionListener {

    private JFrame frame;
    private JScrollPane scrollPane;
    private JList<String> list;

    private Actions actions;

    public Application() {
        actions = new Actions(this);
        createMainFrame();
        frame.setVisible(true);
        createLineArea();
        createMenu();
    }

    public static void main(String[] args) {
        new Application();
    }

    public void createMainFrame() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLineArea() {
        list = new JList<>(new String[]{"Петр", "Вася", "Коля"});
        scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        list.setSelectedIndex(1);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        createFileMenu(menuFile);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);


        frame.setJMenuBar(menuBar);
    }

    private void createFileMenu(JMenu menu) {
        JMenuItem itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");

        JMenuItem itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");

        JMenuItem itemSaveAs = new JMenuItem("Save as");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("SaveAs");

        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        menu.add(itemNew);
        menu.add(itemOpen);
        menu.add(itemSaveAs);
        menu.add(itemSave);
        menu.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();
       switch (command) {
           case "New":
            actions.newCommand();
            break;
           case "Open":
               actions.open();
               break;
           case "SaveAs":
               actions.saveAs();
               break;
       }

    }

    public void setList(String[] newList) {
        list.setListData(newList);
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JList<String> getList() {
        return list;
    }
}
