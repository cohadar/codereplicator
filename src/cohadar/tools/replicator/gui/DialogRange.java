package cohadar.tools.replicator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class DialogRange extends JDialog implements ActionListener {
	IntField a;
	IntField z;
	JButton ok = new JButton("OK");

	private DialogRange(MainFrame mainFrame) {
		super(mainFrame, true);
		a = new IntField(this, 10);
		z = new IntField(this, 10);
		
		this.setTitle("Integer Range");
		
		FormLayout layout = new FormLayout("2dlu, pref, 4dlu, pref:grow, 2dlu",
				"2dlu, fill:pref, 2dlu, fill:pref, 2dlu, pref:grow, 1dlu");
		layout.setRowGroups(new int[][] { { 2, 4, 6 } });
		JPanel panel = new JPanel(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("from:"), cc.xy(2, 2));
		panel.add(a, cc.xy(4, 2));
		panel.add(new JLabel("to:"), cc.xy(2, 4));
		panel.add(z, cc.xy(4, 4));
		panel.add(ok, cc.xyw(2, 6, 3));
		
		a.setText("0");
		z.setText("99");

		this.setContentPane(panel);

		ok.addActionListener(this);

		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(this.getOwner());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuilder res = new StringBuilder();
		int start = a.getInteger();
		int end = z.getInteger();
		if (start <= end) {
			while (start < end) {
				res.append(start);
				res.append('\n');
				start++;
			}
		} else {
			while (start > end) {
				res.append(start);
				res.append('\n');
				start--;
			}
		}
		res.append(end);
		inFocus.setText(res.toString());
		setVisible(false);
	}

	private static DialogRange instance;
	private static AbstractArgumentList inFocus;

	public static void display(MainFrame mainFrame, AbstractArgumentList inFocus) {
		if (instance == null) {
			instance = new DialogRange(mainFrame);
		}
		DialogRange.inFocus = inFocus;
		instance.setVisible(true);
		instance.z.requestFocus();
		instance.z.selectAll();
	}

	public void charNotify() {
		if (a.isValid() && z.isValid()) {
			ok.setEnabled(true);
		} else {
			ok.setEnabled(false);
		}
	}
}
