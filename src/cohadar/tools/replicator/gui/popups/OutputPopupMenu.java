package cohadar.tools.replicator.gui.popups;

import javax.swing.JPopupMenu;

import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.gui.OutputText;

public class OutputPopupMenu extends JPopupMenu {

	public OutputPopupMenu(OutputText owner) {
		// TODO: implement copy block
		//this.add(Actions.COPY_BLOCK);
		this.add(Actions.COPY_ALL);
	}
}
