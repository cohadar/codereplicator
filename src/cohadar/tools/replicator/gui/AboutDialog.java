package cohadar.tools.replicator.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.gui.components.HyperlinkLabel;

public class AboutDialog extends JDialog implements ActionListener {
	private static final String AUTHOR = "Damir Čohadarević";
	private static final String HOME_PAGE = "http://codereplicator.sourceforge.net";
	private static final String LICENSE = "http://www.opensource.org/licenses/mit-license.php";

	private final JButton okButton = new JButton("Ok");
	private final MainFrame mainFrame;

	private AboutDialog(MainFrame mainFrame) {
		super(mainFrame);
		this.mainFrame = mainFrame;
		this.setTitle(MainFrame.TITLE);
		this.setLayout(new BorderLayout());
		this.add(new JLabel(Resources.ICON_REPLICATOR), BorderLayout.WEST);
		this.add(new LinkPanel(), BorderLayout.CENTER);
		this.add(okButton, BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(this.getOwner());
		this.setModal(true);
		okButton.addActionListener(this);
	}


	@Override
	public void setVisible(boolean visible) {
		this.setLocationRelativeTo(this.getOwner());
		super.setVisible(visible);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}

	class LinkPanel extends JPanel implements ActionListener {
		public LinkPanel() {
			this.setBorder(BorderFactory.createLoweredBevelBorder());
			GridLayout thisLayout = new GridLayout(3, 1);
			thisLayout.setHgap(10);
			thisLayout.setVgap(10);
			this.setLayout(thisLayout);

			Font font = this.getFont();
			font = font.deriveFont(font.getSize() * 1.5f);

			JLabel author = new JLabel(AUTHOR);
			this.add(new HGroup(new JLabel("Author:"), author));
			author.setFont(font);

			HyperlinkLabel homePage = new HyperlinkLabel(HOME_PAGE);
			this.add(new HGroup(new JLabel("Home Page:"), homePage));
			homePage.setFont(font);
			homePage.addActionListener(this);

			HyperlinkLabel license = new HyperlinkLabel(LICENSE, "MIT");
			this.add(new HGroup(new JLabel("License:"), license));
			license.setFont(font);
			license.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			HyperlinkLabel hLink = (HyperlinkLabel) e.getSource();
			try {
				hLink.openInBrowser();
				AboutDialog.this.mainFrame
						.setMessage("opening url in browser...");
			} catch (IOException e1) {
				hLink.copyToClipboard();
				AboutDialog.this.mainFrame
						.setMessage("cannot open browser, url copied to clipboard");
			}
		}
	}

	class HGroup extends JPanel {
		public HGroup(JComponent... components) {
			for (JComponent c : components) {
				this.add(c);
			}
		}
	}
	
	private static AboutDialog instance;

	public static void display(MainFrame mainFrame) {
		if (instance == null){
			instance = new AboutDialog(mainFrame);
		}
		instance.setVisible(true);
	}
}
