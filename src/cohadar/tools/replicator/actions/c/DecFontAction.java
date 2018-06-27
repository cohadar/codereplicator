package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class DecFontAction extends AbstractAction{
	public DecFontAction() {
		super(ActionNames.DEC_FONT);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.DEC_FONT);
		if (Resources.ICON_DEC_FONT != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_DEC_FONT);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_DEC_FONT.small());
		}
		if (KeyStrokes.DEC_FONT != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.DEC_FONT);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().decFont();
	}
}



