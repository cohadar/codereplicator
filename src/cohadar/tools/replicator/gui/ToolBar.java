package cohadar.tools.replicator.gui;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.Actions;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

public class ToolBar extends JPanel {

	public ToolBar() {
		FormLayout layout = new FormLayout(
				"pref, pref, 2dlu, pref, pref, 2dlu, pref, max(2dlu;pref):grow, pref, 2dlu, pref, 1dlu",
				"fill:pref, fill:pref, 2dlu");
		this.setLayout(layout);

		JButton paste = new JButton(Actions.PASTE);
		paste.setVerticalTextPosition(SwingConstants.BOTTOM);
		paste.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton cut = new JButton(Actions.CUT);
		cut.setHorizontalAlignment(SwingConstants.LEFT);
		cut.setVerticalTextPosition(SwingConstants.CENTER);
		cut.setHorizontalTextPosition(SwingConstants.RIGHT);
		cut.setIcon(Resources.ICON_CUT.to(24));

		JButton copy = new JButton(Actions.COPY);
		copy.setHorizontalAlignment(SwingConstants.LEFT);
		copy.setVerticalTextPosition(SwingConstants.CENTER);
		copy.setHorizontalTextPosition(SwingConstants.RIGHT);
		copy.setIcon(Resources.ICON_COPY.to(24));

		JButton undo = new JButton(Actions.UNDO);
		undo.setVerticalTextPosition(SwingConstants.BOTTOM);
		undo.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton redo = new JButton(Actions.REDO);
		redo.setVerticalTextPosition(SwingConstants.BOTTOM);
		redo.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton zoomIn = new JButton(Actions.INC_FONT);
		// zoomIn.setHorizontalAlignment(SwingConstants.LEFT);
		zoomIn.setVerticalTextPosition(SwingConstants.BOTTOM);
		zoomIn.setHorizontalTextPosition(SwingConstants.CENTER);
		zoomIn.setIcon(Resources.ICON_INC_FONT.to(24));
		zoomIn.setText(null);

		JButton zoomOut = new JButton(Actions.DEC_FONT);
		// zoomOut.setHorizontalAlignment(SwingConstants.LEFT);
		zoomOut.setVerticalTextPosition(SwingConstants.BOTTOM);
		zoomOut.setHorizontalTextPosition(SwingConstants.CENTER);
		zoomOut.setIcon(Resources.ICON_DEC_FONT.to(24));
		zoomOut.setText(null);

		JButton help = new JButton(Actions.HELP);
		help.setVerticalTextPosition(SwingConstants.BOTTOM);
		help.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton az = new JButton(Actions.AZ);
		JButton range = new JButton(Actions.RANGE);

		layout.setColumnGroups(new int[][] { { 1, 4, 5, 11 }, {7, 9} });

		this.add(paste, CC.xywh(1, 1, 1, 2));
		this.add(cut, CC.xy(2, 1));
		this.add(copy, CC.xy(2, 2));
		this.add(undo, CC.xywh(4, 1, 1, 2));
		this.add(redo, CC.xywh(5, 1, 1, 2));
		this.add(zoomIn, CC.xywh(7, 1, 1, 1));
		this.add(zoomOut, CC.xywh(7, 2, 1, 1));
		this.add(az, CC.xy(9, 1));
		this.add(range, CC.xy(9, 2));
		this.add(help, CC.xywh(11, 1, 1, 2));

		// standard text key strokes have binding by default
		// we bind the rest from toolbar.
		bindKeyStrokeAsGlobal(Actions.AZ);
		bindKeyStrokeAsGlobal(Actions.RANGE);
		bindKeyStrokeAsGlobal(Actions.UNDO);
		bindKeyStrokeAsGlobal(Actions.REDO);
		bindKeyStrokeAsGlobal(Actions.INC_FONT);
		bindKeyStrokeAsGlobal(Actions.DEC_FONT);
		bindKeyStrokeAsGlobal(Actions.HELP);
	}

	private void bindKeyStrokeAsGlobal(Action action) {
		KeyStroke keyStroke = (KeyStroke) action
				.getValue(Action.ACCELERATOR_KEY);
		String actionMapKey = (String) action.getValue(AbstractAction.NAME);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke,
				actionMapKey);
		this.getActionMap().put(actionMapKey, action);
	}
}
