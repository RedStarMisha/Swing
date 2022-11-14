import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Actions {
    private Application app;
    private String fileName = "";
    private String directory = "";

    public Actions(Application app) {
        this.app = app;
    }

    public void newCommand() {
        app.setList(new String[0]);
        app.setTitle("New");
    }

    public void open() {
        FileDialog dialog = new FileDialog(app.getFrame(), "Open", FileDialog.LOAD);
        dialog.setVisible(true);

        if (dialog.getFile() != null) {
            fileName = dialog.getFile();
            directory = dialog.getDirectory();
            app.setTitle(fileName);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(directory + fileName))) {
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            String[] array = list.toArray(new String[0]);
            app.setList(array);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void save() {

    }

    public void saveAs() {
        FileDialog dialog = new FileDialog(app.getFrame(), "Save", FileDialog.SAVE);
        dialog.setVisible(true);

        if (dialog.getFile() != null) {
            fileName = dialog.getFile();
            directory = dialog.getDirectory();
            app.setTitle(fileName);
        }

        try (FileWriter fw = new FileWriter(directory + fileName)) {
            StringBuilder builder = new StringBuilder();
            ListModel<String> array = app.getList().getModel();
            for(int i = 0; i < array.getSize(); i++) {
                fw.write(array.getElementAt(i) + "\n");
                fw.
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
