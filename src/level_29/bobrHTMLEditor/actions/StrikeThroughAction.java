package level_29.bobrHTMLEditor.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {

    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public StrikeThroughAction(String nm) {
        super(nm);
    }
    public StrikeThroughAction() {
        super(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
