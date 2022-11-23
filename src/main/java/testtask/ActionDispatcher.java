package testtask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionDispatcher implements ActionListener {
    private final EditMenuActions editMenuActions;
    private final FileMenuActions fileMenuActions;


    public ActionDispatcher(AppInterface appInterface) {
        this.editMenuActions = new EditMenuActions(appInterface);
        this.fileMenuActions = new FileMenuActions(appInterface);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        makeAction(command);
    }

    public void makeAction(String command) {
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
}
