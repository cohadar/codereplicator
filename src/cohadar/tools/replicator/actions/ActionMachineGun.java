package cohadar.tools.replicator.actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.EventListenerList;

/**
 * Fires custom ActionEvents.
 * */
public class ActionMachineGun {
	protected EventListenerList listenerList = new EventListenerList();

	public void fireActionEvent(Object source, String actionCommand) {
		fireActionEvent(source, actionCommand, 0);
	}
	
	public void fireActionEvent(Object source, String actionCommand, int modifiers) {
		fireActionPerformed(new ActionEvent(source, ActionEvent.ACTION_PERFORMED,
				actionCommand, EventQueue.getMostRecentEventTime(), modifiers));
	}

	public void addActionListener(ActionListener l) {
		listenerList.add(ActionListener.class, l);
	}

	public void removeActionListener(ActionListener l) {
		listenerList.remove(ActionListener.class, l);
	}

	/**
	 * Notifies all listeners that have registered interest for notification on
	 * this event type. see EventListenerList documentation for details.
	 */
	protected void fireActionPerformed(ActionEvent e) {
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ActionListener.class) {
				((ActionListener) listeners[i + 1]).actionPerformed(e);
			}
		}
	}
}