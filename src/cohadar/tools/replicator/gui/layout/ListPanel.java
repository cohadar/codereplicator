package cohadar.tools.replicator.gui.layout;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListPanel extends JPanel {
	public ListPanel(JComponent c, JComponent d) {
		super(new GridLayout(1, 2));

		JScrollPane sc = new JScrollPane(c);
		JScrollPane sd = new JScrollPane(d);

		this.add(sc);
		this.add(sd);
	}

}
