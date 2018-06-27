package cohadar.tools.replicator.gui.layout;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class InOutPanel extends JSplitPane {
	public InOutPanel(JComponent a, JComponent b) {
		super(JSplitPane.VERTICAL_SPLIT);

		JScrollPane sa = new JScrollPane(a);
		JScrollPane sb = new JScrollPane(b);

		// sa.setBorder(new TitledBorder("template"));
		// sb.setBorder(new TitledBorder("output"));

		this.add(sa);
		this.add(sb);

	}
}
