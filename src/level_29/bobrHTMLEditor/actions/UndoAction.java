package level_29.bobrHTMLEditor.actions;

import level_29.bobrHTMLEditor.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {
    View view;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public UndoAction(View view) {this.view = view;}
}
