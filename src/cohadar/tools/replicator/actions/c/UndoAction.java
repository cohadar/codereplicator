package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class UndoAction extends AbstractAction{
	public UndoAction() {
		super(ActionNames.UNDO);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.UNDO);
		if (Resources.ICON_UNDO != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_UNDO);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_UNDO.small());
		}
		if (KeyStrokes.UNDO != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.UNDO);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().undo();
	}
}



