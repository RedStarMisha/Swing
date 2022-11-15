package testtask;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileMenuActions {
    private Application app;

    private final JListDecorator list;
    private String fileName = "";
    private String directory = "";

    public FileMenuActions(Application app) {
        this.app = app;
        list = app.getList();
    }

    public void newCommand() {
        list.setEmptyList();
        app.getFrame().setTitle("New");
        fileName = null;
        directory = null;
    }

    public void open() {
        FileDialog dialog = new FileDialog(app.getFrame(), "Open", FileDialog.LOAD);
        dialog.setVisible(true);

        if (dialog.getFile() != null) {
            fileName = dialog.getFile();
            directory = dialog.getDirectory();
            app.getFrame().setTitle(fileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(directory + fileName))) {
                DefaultListModel<String> listModel = new DefaultListModel<>();
                while (reader.ready()) {
                    listModel.addElement(reader.readLine());
                }
                list.setNewList(listModel);
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
            ListModel<String> array = app.getList().getModel();
            for(int i = 0; i < array.getSize(); i++) {
                fw.write(array.getElementAt(i) + System.getProperty("line.separator"));
            }
            app.getFrame().setTitle(fileName);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void saveAs() {
        JFrame frame = app.getFrame();
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.setVisible(true);

        if (dialog.getFile() != null) {
            fileName = dialog.getFile();
            directory = dialog.getDirectory();
            frame.setTitle(fileName);
        }

        try (FileWriter fw = new FileWriter(directory + fileName)) {
            ListModel<String> array = app.getList().getModel();
            for(int i = 0; i < array.getSize(); i++) {
                fw.write(array.getElementAt(i)+ "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void exit() {
        System.exit(0);
    }
}
