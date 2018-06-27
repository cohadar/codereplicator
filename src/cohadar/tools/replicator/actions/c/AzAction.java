package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class AzAction extends AbstractAction{
	public AzAction() {
		super(ActionNames.AZ);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.AZ);
		if (Resources.ICON_AZ != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_AZ);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_AZ.small());
		}
		if (KeyStrokes.AZ != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.AZ);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().az();
	}
}



