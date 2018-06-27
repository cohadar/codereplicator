package cohadar.tools.replicator.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cohadar.tools.replicator.gui.MainFrame;

/**
 * Tracks changes of input text areas and periodically updates output text area.
 * */
public class PeriodicTimer implements ActionListener, DocumentListener {
	public static final int TIMER_DELAY = 1000; // milliseconds
	private final MainFrame mainFrame;

	public PeriodicTimer(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		mainFrame.getList1().getDocument().addDocumentListener(this);
		mainFrame.getList2().getDocument().addDocumentListener(this);
		mainFrame.getInput().getDocument().addDocumentListener(this);

		Timer timer = new Timer(TIMER_DELAY, this);
		timer.setInitialDelay(TIMER_DELAY);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (changed) {
			changed = false;
			try {
				mainFrame.replicate();
			} catch (Throwable t) {
				JOptionPane.showMessageDialog(mainFrame, t.getMessage(), t
						.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
				t.printStackTrace();
			}
		}
		try {
			mainFrame.tick();
		} catch (Throwable t) {
			// no dialog here because it would spam every sec.
			t.printStackTrace();
		}
	}

	private boolean changed = true;

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		this.changed = true;
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.changed = true;
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.changed = true;
	}
}
