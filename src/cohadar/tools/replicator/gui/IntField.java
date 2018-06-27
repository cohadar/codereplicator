package cohadar.tools.replicator.gui;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// TODO: add hex / binary support
public class IntField extends JTextField implements DocumentListener {
	private boolean valid = true;
	private final DialogRange owner;

	public boolean isValid() {
		return valid;
	}
	
	public int getInteger(){
		return Integer.parseInt(this.getText());
	}

	public IntField(DialogRange owner, int columns) {
		super(columns);
		this.owner = owner;
		this.getDocument().addDocumentListener(this);
	}

	private void verify() {
		try{
			Integer.parseInt(this.getText());
			valid = true;
		}catch(NumberFormatException e){
			valid = false;
		}
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
