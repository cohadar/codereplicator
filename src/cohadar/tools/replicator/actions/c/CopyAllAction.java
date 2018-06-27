
package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class CopyAllAction extends AbstractAction{
	public CopyAllAction() {
		super(ActionNames.COPY_ALL);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.COPY_ALL);
		if (Resources.ICON_COPY_ALL != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_COPY_ALL);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_COPY_ALL.small());
		}
		if (KeyStrokes.COPY_ALL != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.COPY_ALL);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().copyAll();
	}
}




