package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class CutAction extends AbstractAction{
	public CutAction() {
		super(ActionNames.CUT);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.CUT);
		if (Resources.ICON_CUT != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_CUT);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_CUT.small());
		}
		if (KeyStrokes.CUT != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.CUT);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().cut();
	}
}



