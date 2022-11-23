package testtask;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileMenuActions {
    private AppInterface appInterface;
    private final JListDecorator list;
    private String fileName;
    private String directory;

    public FileMenuActions(AppInterface appInterface) {
        this.appInterface = appInterface;
        this.list = appInterface.getList();
    }

    public void newCommand() {
        list.setEmptyList();
        appInterface.setTitle("New");
        fileName = null;
        directory = null;
    }

    public void open() {
        FileDialog dialog = new FileDialog(appInterface, "Open", FileDialog.LOAD);
        dialog.setVisible(true);

        if (dialog.getFile() != null) {
            fileName = dialog.getFile();
            directory = dialog.getDirectory();
            appInterface.setTitle(fileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(directory + fileName))) {
                Set<String> set = new HashSet<>();
                while (reader.ready()) {
                    set.add(reader.readLine());
                }
                list.setNewList(set);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public void save() {
        if (fileName == null) {
            saveAs();
            return;
        }
        try (FileWriter fw = new FileWriter(directory + fileName)) {
            ListModel<String> array = list.getModel();
            for (int i = 0; i < array.getSize(); i++) {
                fw.write(array.getElementAt(i) + "\r\n");
            }
            appInterface.setTitle(fileName);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void saveAs() {
        FileDialog dialog = new FileDialog(appInterface, "Save", FileDialog.SAVE);
        dialog.setVisible(true);

        if (dialog.getFile() != null) {
            fileName = dialog.getFile();
            directory = dialog.getDirectory();
            appInterface.setTitle(fileName);
        }

        try (FileWriter fw = new FileWriter(directory + fileName)) {
            ListModel<String> array = list.getModel();
            for (int i = 0; i < array.getSize(); i++) {
                fw.write(array.getElementAt(i) + "\r\n");
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void exit() {
        System.exit(0);
    }
}
