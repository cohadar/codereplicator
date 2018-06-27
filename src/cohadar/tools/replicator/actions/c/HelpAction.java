package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class HelpAction extends AbstractAction{
	public HelpAction() {
		super(ActionNames.HELP);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.HELP);
		if (Resources.ICON_HELP != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_HELP);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_HELP.small());
		}
		if (KeyStrokes.HELP != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.HELP);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().help();
	}
}



