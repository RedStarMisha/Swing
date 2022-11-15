package testtask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application implements ActionListener {

    private JFrame frame = new JFrame();;
    private JListDecorator list;

    private FileMenuActions fileMenuActions;

    private EditMenuActions editMenuActions;

    public Application() {
        createMainFrame();
        createLineArea();
        createMenu();
        frame.setVisible(true);
        fileMenuActions = new FileMenuActions(this);
        editMenuActions = new EditMenuActions(this);
        dragAndDropListElements();
    }

    public static void main(String[] args) {
        new Application();
    }

    public void createMainFrame() {
        //frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLineArea() {
        list = new JListDecorator(new DefaultListModel<>());
        frame.setTitle("New");
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        list.setSelectedIndex(1);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        createFileMenu(menuFile);
        createEditMenu(menuEdit);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        frame.setJMenuBar(menuBar);
    }

    private void dragAndDropListElements() {
        DraggingActions draggingActions = new DraggingActions(list);
        list.addMouseListener(draggingActions);
        list.addMouseMotionListener(draggingActions);
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
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setActionCommand("Exit");

        menu.add(itemNew);
        menu.add(itemOpen);
        menu.add(itemSaveAs);
        menu.add(itemSave);
        menu.add(exit);
    }

    public void createEditMenu(JMenu menuEdit) {
        JMenuItem itemAddElement = new JMenuItem("Add element");
        itemAddElement.addActionListener(this);
        itemAddElement.setActionCommand("Add element");

        JMenuItem itemChangeElement = new JMenuItem("Edit element");
        itemChangeElement.addActionListener(this);
        itemChangeElement.setActionCommand("Edit element");

        JMenuItem itemDeleteElement = new JMenuItem("Delete element");
        itemDeleteElement.addActionListener(this);
        itemDeleteElement.setActionCommand("Delete element");

        JMenuItem itemDeleteAll = new JMenuItem("Delete All");
        itemDeleteAll.addActionListener(this);
        itemDeleteAll.setActionCommand("Delete All");

        JMenuItem itemSort = new JMenuItem("Sort");
        itemSort.addActionListener(this);
        itemSort.setActionCommand("Sort");

        menuEdit.add(itemAddElement);
        menuEdit.add(itemChangeElement);
        menuEdit.add(itemDeleteElement);
        menuEdit.add(itemDeleteAll);
        menuEdit.add(itemSort);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();
       switch (command) {
           case "New":
            fileMenuActions.newCommand();
            break;
           case "Open":
               fileMenuActions.open();
               break;
           case "SaveAs":
               fileMenuActions.saveAs();
               break;
           case "Save":
               fileMenuActions.save();
               break;
           case "Exit":
                fileMenuActions.exit();
                break;
           case "Add element":
               editMenuActions.addElement();
               break;
           case "Edit element":
               editMenuActions.editElement();
               break;
           case "Delete element":
               editMenuActions.deleteElement();
               break;
           case "Delete All":
               editMenuActions.deleteAllElement();
               break;
           case "Sort":
               editMenuActions.sort();
       }
    }

    public JFrame getFrame() {
        return frame;
    }

    public JListDecorator getList() {
        return list;
    }
}
