package cohadar.tools.replicator.actions.c;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.ActionNames;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.actions.KeyStrokes;
import cohadar.tools.replicator.actions.ShortDescriptions;

public class IncFontAction extends AbstractAction{
	public IncFontAction() {
		super(ActionNames.INC_FONT);
		putValue(SHORT_DESCRIPTION, ShortDescriptions.INC_FONT);
		if (Resources.ICON_INC_FONT != null) {
			putValue(AbstractAction.LARGE_ICON_KEY, Resources.ICON_INC_FONT);
			putValue(AbstractAction.SMALL_ICON, Resources.ICON_INC_FONT.small());
		}
		if (KeyStrokes.INC_FONT != null) {
			putValue(ACCELERATOR_KEY, KeyStrokes.INC_FONT);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Actions.getTarget().incFont();
	}
}



