package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class PasteAction extends AbstractAction{
	public PasteAction() {
		super(ActionNames.PASTE);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.PASTE);
		if (Resources.ICON_PASTE != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_PASTE);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_PASTE.small());
		}
		if (KeyStrokes.PASTE != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.PASTE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().paste();
	}
}



