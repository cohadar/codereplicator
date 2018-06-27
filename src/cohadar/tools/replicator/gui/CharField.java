package cohadar.tools.replicator.gui;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// TODO: add unicode escape representation support
public class CharField extends JTextField implements DocumentListener {
	private boolean valid = true;
	private final DialogAZ owner;

	public boolean isValid() {
		return valid;
	}
	
	public char getChar(){
		return this.getText().charAt(0);
	}

	public CharField(DialogAZ owner, int columns) {
		super(columns);
		this.owner = owner;
		this.getDocument().addDocumentListener(this);
	}

	private void verify() {
		valid = (this.getText().length() == 1);
		owner.charNotify();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// verify();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		verify();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		verify();
	}

}
