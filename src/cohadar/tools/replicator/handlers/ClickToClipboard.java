package cohadar.tools.replicator.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cohadar.tools.replicator.gui.OutputText;

// Must be registered to a JTextComponent subclass
// example: textComponent.addMouseListener(new ClickToClipboard());
public class ClickToClipboard extends MouseAdapter {

	private final OutputText outputText;

	public ClickToClipboard(OutputText outputText) {
		this.outputText = outputText;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		outputText.copy();
	}
}
