package level_29.bobrHTMLEditor.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SubscriptAction extends StyledEditorKit.StyledTextAction {


    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public SubscriptAction(String nm) {
        super(nm);
    }
    public SubscriptAction() {
        super(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
