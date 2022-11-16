package testtask;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.*;

public class JListDecorator extends JList<String> {
    private Map<String, LocalDateTime> map;
    private DefaultListModel<String> listModel;
    public JListDecorator(ListModel<String> dataModel) {
        super(dataModel);
        listModel = (DefaultListModel<String>) dataModel;
    }

    public void setNewList(Set<String> model) {
        map = new HashMap<>();
        listModel = new DefaultListModel<>();
        LocalDateTime now = LocalDateTime.now();
        model.forEach((key) -> {
            map.put(key, now);
            listModel.addElement(key);
        });
        super.setModel(listModel);
    }

    public void setEmptyList() {
        listModel = new DefaultListModel<>();
        map = new HashMap<>();
        super.setModel(listModel);
    }

    public void addElement(String element) {
        if (!map.containsKey(element)) {
            map.put(element, LocalDateTime.now());
            listModel.addElement(element);
            super.setModel(listModel);
        }
    }

    public void editElement(int ind, String name) {
            listModel.set(ind, name);
            super.setModel(listModel);
    }

    public void deleteElement(int ind) {
        listModel.remove(ind);
        super.setModel(listModel);
    }

    public void sortByDate() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach((entry) -> listModel.addElement(entry.getKey()));
        super.setModel(listModel);
    }

    public void sortByName() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((entry) -> listModel.addElement(entry.getKey()));
        super.setModel(listModel);
    }

    public void sortByLength() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(comparator))
                .forEach((entry) -> listModel.addElement(entry.getKey()));
        super.setModel(listModel);
    }
}
