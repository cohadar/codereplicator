package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class SelectAllAction extends AbstractAction{
	public SelectAllAction() {
		super(ActionNames.SELECT_ALL);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.SELECT_ALL);
		if (Resources.ICON_SELECT_ALL != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_SELECT_ALL);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_SELECT_ALL.small());
		}
		if (KeyStrokes.SELECT_ALL != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.SELECT_ALL);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().selectAll();
	}
}



