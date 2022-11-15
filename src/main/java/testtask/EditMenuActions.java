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
        JDialog dialog = new JDialog();
        dialog.setLocationRelativeTo(application.getFrame());

        JRadioButton sort1 = new JRadioButton("В алфавитном порядке");
        JRadioButton sort2 = new JRadioButton("По длине строк");
        JRadioButton sort3 = new JRadioButton("По порядку добавления");
        ButtonGroup group = new ButtonGroup();
        group.add(sort1);
        group.add(sort2);
        group.add(sort3);
        JLabel label = new JLabel("Как сортировать:");
        Icon icon = new ImageIcon("sort.jpg");

        label.setIcon(icon);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;

        gbc.gridx = 0;
        gbc.gridy = 1;
        radioPanel.add(label);

        gbc.gridx = 0;
        gbc.gridy = 1;
        radioPanel.add(sort1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        radioPanel.add(sort2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        radioPanel.add(sort3, gbc);

        JButton button = new JButton("Sort");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

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
