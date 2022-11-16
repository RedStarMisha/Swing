package testtask;

public class ActionFactory {
    private final EditMenuActions editMenuActions;
    private final FileMenuActions fileMenuActions;

    public ActionFactory(Application application) {
        this.editMenuActions = new EditMenuActions(application);
        this.fileMenuActions = new FileMenuActions(application);
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
