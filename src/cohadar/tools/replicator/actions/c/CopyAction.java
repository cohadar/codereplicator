package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class CopyAction extends AbstractAction{
	public CopyAction() {
		super(ActionNames.COPY);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.COPY);
		if (Resources.ICON_COPY != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_COPY);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_COPY.small());
		}
		if (KeyStrokes.COPY != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.COPY);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().copy();
	}
}



