package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class RedoAction extends AbstractAction{
	public RedoAction() {
		super(ActionNames.REDO);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.REDO);
		if (Resources.ICON_REDO != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_REDO);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_REDO.small());
		}
		if (KeyStrokes.REDO != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.REDO);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().redo();
	}
}



