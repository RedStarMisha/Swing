package testtask;

import javax.swing.*;
import java.awt.*;

public class EditMenuActions {
    private Application application;
    private final JListDecorator list;

    public EditMenuActions(Application application) {
        this.application = application;
        list = application.getList();
    }

    public void addElement() {
        String name = JOptionPane.showInputDialog("Enter a new element");
        list.addElement(name);
    }

    public void editElement() {
        String element = list.getSelectedValue();
        if (element != null) {
            int ind = list.getSelectedIndex();

            String name = JOptionPane.showInputDialog(null, "Enter a new element", element);
            if (!element.equals(name)) {
                list.editElement(ind, name);
            }
        }
    }

    public void deleteAllElement() {
        JOptionPane.showConfirmDialog(null, "Are you Sure? Action is irreversible");
        list.setEmptyList();
    }

    public void deleteElement() {
        String element = list.getSelectedValue();
        if (element != null) {
            int ind = list.getSelectedIndex();
            int choice = JOptionPane.showConfirmDialog(null, "Delete " + element + "?");
            if (choice == 0) {
                list.deleteElement(ind);
            }
        }
    }

    public void sort() {

        JLabel label = new JLabel("Как сортировать:");
        Icon icon = new ImageIcon("sort.jpg");
        label.setIcon(icon);

        JRadioButton sort1 = new JRadioButton("В алфавитном порядке");
        sort1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JRadioButton sort2 = new JRadioButton("По длине строк");
        sort2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JRadioButton sort3 = new JRadioButton("По порядку добавления");
        sort3.setAlignmentX(Component.LEFT_ALIGNMENT);

        ButtonGroup group = new ButtonGroup();
        group.add(sort1);
        group.add(sort2);
        group.add(sort3);

        JPanel radioPanel = new JPanel();
        BoxLayout layout = new BoxLayout(radioPanel, BoxLayout.Y_AXIS);

        radioPanel.setLayout(layout);
        radioPanel.add(sort1);
        radioPanel.add(sort2);
        radioPanel.add(sort3);

        JButton button = new JButton("Sort");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        JDialog dialog = new JDialog();
        dialog.setTitle("Sorting");
        dialog.setLocationRelativeTo(application.getFrame());

        dialog.add(label, BorderLayout.NORTH);
        dialog.add(radioPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setSize(200, 200);

        dialog.setVisible(true);
        button.addActionListener((e -> {
            if (sort1.isSelected()) {
                list.sortByName();
                dialog.setVisible(false);
            } else if (sort2.isSelected()) {
                list.sortByLength();
                dialog.setVisible(false);
            } else if (sort3.isSelected()) {
                list.sortByDate();
                dialog.setVisible(false);
            }
        }));
    }
}
