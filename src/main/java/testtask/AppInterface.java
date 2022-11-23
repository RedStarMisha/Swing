package testtask;

import javax.swing.*;

public class AppInterface extends JFrame {

    private JListDecorator list;
    private final ActionDispatcher actionDispatcher;

    public AppInterface() {
        setMainFrame();
        createLineArea();
        actionDispatcher = new ActionDispatcher(this);
        createMenu();
        this.setVisible(true);
        dragAndDropListElements();
    }

    public void setMainFrame() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLineArea() {
        list = new JListDecorator(new DefaultListModel<>());
        this.setTitle("New");
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        list.setSelectedIndex(1);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(scrollPane);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        createFileMenu(menuFile);
        createEditMenu(menuEdit);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        this.setJMenuBar(menuBar);
    }

    private void dragAndDropListElements() {
        DraggingActions draggingActions = new DraggingActions(list);
        list.addMouseListener(draggingActions);
        list.addMouseMotionListener(draggingActions);
    }

    private void createFileMenu(JMenu menu) {
        JMenuItem itemNew = new JMenuItem("New");
        itemNew.addActionListener(actionDispatcher);
        itemNew.setActionCommand("New");

        JMenuItem itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(actionDispatcher);
        itemOpen.setActionCommand("Open");

        JMenuItem itemSaveAs = new JMenuItem("Save as");
        itemSaveAs.addActionListener(actionDispatcher);
        itemSaveAs.setActionCommand("SaveAs");

        JMenuItem itemSave = new JMenuItem("Save");
        itemSave.addActionListener(actionDispatcher);
        itemSave.setActionCommand("Save");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(actionDispatcher);
        exit.setActionCommand("Exit");

        menu.add(itemNew);
        menu.add(itemOpen);
        menu.add(itemSaveAs);
        menu.add(itemSave);
        menu.add(exit);
    }

    public void createEditMenu(JMenu menuEdit) {
        JMenuItem itemAddElement = new JMenuItem("Add element");
        itemAddElement.addActionListener(actionDispatcher);
        itemAddElement.setActionCommand("Add element");

        JMenuItem itemChangeElement = new JMenuItem("Edit element");
        itemChangeElement.addActionListener(actionDispatcher);
        itemChangeElement.setActionCommand("Edit element");

        JMenuItem itemDeleteElement = new JMenuItem("Delete element");
        itemDeleteElement.addActionListener(actionDispatcher);
        itemDeleteElement.setActionCommand("Delete element");

        JMenuItem itemDeleteAll = new JMenuItem("Delete All");
        itemDeleteAll.addActionListener(actionDispatcher);
        itemDeleteAll.setActionCommand("Delete All");

        JMenuItem itemSort = new JMenuItem("Sort");
        itemSort.addActionListener(actionDispatcher);
        itemSort.setActionCommand("Sort");

        menuEdit.add(itemAddElement);
        menuEdit.add(itemChangeElement);
        menuEdit.add(itemDeleteElement);
        menuEdit.add(itemDeleteAll);
        menuEdit.add(itemSort);
    }

    public JListDecorator getList() {
        return list;
    }
}
