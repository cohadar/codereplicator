package cohadar.tools.replicator.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextArea;

import cohadar.tools.replicator.handlers.ClickToClipboard;
import cohadar.tools.replicator.handlers.TextTarget;

public class OutputText extends JTextArea{

	private final MainFrame mainFrame;

	public OutputText(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setRows(20);
		this.setColumns(80);
		this.setTabSize(4);
		this.setEditable(false);
		this.setBackground(Color.LIGHT_GRAY);
		this.addMouseListener(new ClickToClipboard(this));
	}

	/**
	 * Copy selected text, or if no text selected copy everything.
	 * */
	@Override
	public void copy() {
		String selection = this.getSelectedText();
		if (selection == null) {
			selection = this.getText();
		}
		StringSelection data = new StringSelection(selection);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(data, data);
		mainFrame.setMessage("output text copied to clipboard");
	}

	public void copyAll() {
		StringSelection data = new StringSelection(this.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(data, data);
		mainFrame.setMessage("output text copied to clipboard");
	}

	public void copyBlock() {
		throw new UnsupportedOperationException("copyBlock NYI");
	}
}
