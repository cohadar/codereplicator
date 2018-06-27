package cohadar.tools.replicator.handlers;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

public class PopupListener extends MouseAdapter {

	private final JPopupMenu popup;

	public PopupListener(JPopupMenu owner) {
		this.popup = owner;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		if (me.isPopupTrigger()) {
			Component invoker = me.getComponent();
			invoker.requestFocus();
			popup.show(invoker, me.getX(), me.getY());
		}
	}	
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if (me.isPopupTrigger()) {
			Component invoker = me.getComponent();
			invoker.requestFocus();
			popup.show(invoker, me.getX(), me.getY());
		}
	}
}
