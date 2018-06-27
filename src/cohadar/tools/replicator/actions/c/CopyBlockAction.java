package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class CopyBlockAction extends AbstractAction{
	public CopyBlockAction() {
		super(ActionNames.COPY_BLOCK);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.COPY_BLOCK);
		if (Resources.ICON_COPY_BLOCK != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_COPY_BLOCK);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_COPY_BLOCK.small());
		}
		if (KeyStrokes.COPY_BLOCK != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.COPY_BLOCK);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().copyBlock();
	}
}


