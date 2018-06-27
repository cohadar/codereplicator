package cohadar.tools.replicator.gui.popups;

import java.awt.Component;

import javax.swing.JPopupMenu;
import javax.swing.text.JTextComponent;

import cohadar.tools.replicator.actions.Actions;

public class GenericPopupMenu extends JPopupMenu {

	private final JTextComponent owner;

	public GenericPopupMenu(JTextComponent owner) {
		this.owner = owner;
		add(Actions.CUT);
		add(Actions.COPY);
		add(Actions.PASTE);
		add(Actions.DELETE);
		this.addSeparator();
		add(Actions.SELECT_ALL);
	}

	@Override
	public void show(Component invoker, int x, int y) {
		boolean isEnabled = owner.isEnabled();
		boolean hasSelection = (owner.getSelectionEnd() != owner
				.getSelectionStart());
		boolean isEditable = owner.isEditable() && owner.isEditable();

		Actions.CUT.setEnabled(isEnabled && hasSelection && isEditable);
		Actions.COPY.setEnabled(isEnabled && hasSelection);
		Actions.PASTE.setEnabled(isEnabled && isEditable);
		Actions.DELETE.setEnabled(isEnabled && hasSelection && isEditable);
		Actions.SELECT_ALL.setEnabled(isEnabled);
		
		super.show(invoker, x, y);
	}

}
