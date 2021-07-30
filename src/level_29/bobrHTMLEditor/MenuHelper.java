package level_29.bobrHTMLEditor;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem jMenuItem = new JMenuItem(text);
        jMenuItem.addActionListener(actionListener);
        parent.add(jMenuItem);
        return jMenuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem jMenuItem = new JMenuItem(action);
        parent.add(jMenuItem);
        return jMenuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem jMenuItem = addMenuItem(parent, action);
        jMenuItem.setText(text);
        parent.add(jMenuItem);
        return jMenuItem;
    }

    public void initHelpMenu(View view, JMenuBar menuBar) {

    }

    public void initFontMenu(View view, JMenuBar menuBar) {

    }

    public void initColorMenu(View view, JMenuBar menuBar) {

    }

    public void initAlignMenu(View view, JMenuBar menuBar) {

    }

    public void initStyleMenu(View view, JMenuBar menuBar) {

    }

    public void initEditMenu(View view, JMenuBar menuBar) {

    }

    public void initFileMenu(View view, JMenuBar menuBar) {

    }
}
