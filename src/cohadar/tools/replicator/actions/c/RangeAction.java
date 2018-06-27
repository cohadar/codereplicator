package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class RangeAction extends AbstractAction{
	public RangeAction() {
		super(ActionNames.RANGE);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.RANGE);
		if (Resources.ICON_RANGE != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_RANGE);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_RANGE.small());
		}
		if (KeyStrokes.RANGE != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.RANGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().range();
	}
}



