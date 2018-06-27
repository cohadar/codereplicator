package cohadar.tools.replicator.actions;

import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.*;

import javax.swing.KeyStroke;

public class KeyStrokes {
	public static final KeyStroke DEC_FONT = Ctrl(VK_SUBTRACT);
	public static final KeyStroke INC_FONT = Ctrl(VK_ADD);
	public static final KeyStroke AZ = Alt(VK_A);
	public static final KeyStroke RANGE = Alt(VK_0);
	public static final KeyStroke HELP = Plain(VK_F1);
	public static final KeyStroke CUT = Ctrl(VK_X);
	public static final KeyStroke COPY = Ctrl(VK_C);
	public static final KeyStroke PASTE = Ctrl(VK_V);
	public static final KeyStroke DELETE = Plain(VK_DELETE);
	public static final KeyStroke SELECT_ALL = Ctrl(VK_A);
	public static final KeyStroke COPY_ALL = null;
	public static final KeyStroke COPY_BLOCK = null;
	public static final KeyStroke UNDO = Ctrl(VK_Z);
	public static final KeyStroke REDO = Ctrl(VK_Y);

	private static KeyStroke Ctrl(int c) {
		return KeyStroke.getKeyStroke(c, ActionEvent.CTRL_MASK);
	}

	private static KeyStroke Alt(int c) {
		return KeyStroke.getKeyStroke(c, ActionEvent.ALT_MASK);
	}

	private static KeyStroke Plain(int c) {
		return KeyStroke.getKeyStroke(c, 0);
	}

}
