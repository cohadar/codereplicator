package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class DeleteAction extends AbstractAction{
	public DeleteAction() {
		super(ActionNames.DELETE);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.DELETE);
		if (Resources.ICON_DELETE != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_DELETE);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_DELETE.small());
		}
		if (KeyStrokes.DELETE != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.DELETE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().delete();
	}
}



