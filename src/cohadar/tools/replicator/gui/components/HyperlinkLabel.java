package cohadar.tools.replicator.gui.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;

import cohadar.tools.replicator.actions.ActionMachineGun;

/**
 * An underlined label that fires Action when clicked. Mouse over changes cursor
 * to hand like in browser.
 * */
public class HyperlinkLabel extends JLabel {

	private final ActionMachineGun amg = new ActionMachineGun();

	public void addActionListener(ActionListener l) {
		amg.addActionListener(l);
	}

	public void removeActionListener(ActionListener l) {
		amg.removeActionListener(l);
	}

	public HyperlinkLabel(String url) {
		this(url, null);
	}

	public static final Color DEFAULT_LINK_COLOR = Color.BLUE;

	public HyperlinkLabel(String url, String label) {
		addMouseListener(new ClickAdapter());
		setUI(UnderlinedLabelUI.instance);
		this.url = url;
		if (label == null) {
			setText(url);
		} else {
			setText(label);
		}
		this.setForeground(DEFAULT_LINK_COLOR);
	}

	private final String url;

	public String getURL() {
		return url;
	}

	private class ClickAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent mev) {
			if (isEnabled()) {
				amg.fireActionEvent(HyperlinkLabel.this, "click", mev
						.getButton());
			}
		}

		@Override
		public void mouseEntered(MouseEvent mev) {
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent mev) {
			setCursor(Cursor.getDefaultCursor());
		}
	}

	public void openInBrowser() throws IOException {
		java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	}

	public void copyToClipboard() {
		StringSelection data = new StringSelection(url);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(data, data);
	}

}
