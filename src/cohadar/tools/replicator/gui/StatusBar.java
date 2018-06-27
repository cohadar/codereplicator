package cohadar.tools.replicator.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	private final JLabel label;
	private String oldMessage = "";
	private int repetitionCounter = 1;

	public StatusBar() {
		this.add(label = new JLabel("..."));
	}

	public void setMessage(String msg) {
		if (oldMessage == msg) {
			repetitionCounter++;
			label.setText(String.format("%s [%d]", msg, repetitionCounter));
		} else {
			label.setText(msg);
			repetitionCounter = 1;
		}

		if (msg == null) {
			oldMessage = "";
		} else {
			oldMessage = msg;
		}
	}

	@Override
	public void setFont(Font font) {
		super.setFont(font);
		if (label != null) {
			label.setFont(font);
		}
	}
}
