package testtask;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class DraggingActions extends MouseInputAdapter {
    private final JListDecorator list;
    private boolean mouseDragging = false;
    private int dragSourceIndex;

    public DraggingActions(JListDecorator list) {
        this.list = list;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            dragSourceIndex = list.getSelectedIndex();
            mouseDragging = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (mouseDragging) {
            int currentIndex = list.locationToIndex(e.getPoint());
            if (currentIndex != dragSourceIndex) {
                DefaultListModel<String> listModel = (DefaultListModel<String>) list.getModel();
                int targetIndex = list.getSelectedIndex();
                String element = listModel.get(dragSourceIndex);
                listModel.remove(dragSourceIndex);
                listModel.add(targetIndex, element);
                list.setModel(listModel);
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseDragging = true;
    }
}
