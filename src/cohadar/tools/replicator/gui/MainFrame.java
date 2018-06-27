package cohadar.tools.replicator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import cohadar.tools.replicator.Resources;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.engine.Text;
import cohadar.tools.replicator.gui.layout.InOutPanel;
import cohadar.tools.replicator.gui.layout.ListPanel;
import cohadar.tools.replicator.handlers.MyFocusTraversalPolicy;
import cohadar.tools.replicator.handlers.TextTarget;

public class MainFrame extends JFrame {

	public static final String TITLE = "Cohadar's Code Replicator v2.0";

	static final Color COLOR_FOCUSED = new Color(200, 255, 255);
	// TODO: what if system default is not white?
	static final Color COLOR_DEFAULT = Color.WHITE;

	private AbstractTextTarget inFocus = null;

	private final TemplateText in;
	private final OutputText out;
	private final AbstractArgumentList arglist1;
	private final AbstractArgumentList arglist2;

	private final StatusBar statusBar;

	public AbstractTextTarget getFocusedOne() {
		return inFocus;
	}

	public void setFocusedOne(TextTarget component) {
		if (inFocus != component) {
			inFocus.setBackground(COLOR_DEFAULT);
			inFocus = (AbstractTextTarget) component;
			inFocus.setBackground(COLOR_FOCUSED);

			if (inFocus == in) {
				Actions.AZ.setEnabled(false);
				Actions.RANGE.setEnabled(false);
			} else {
				Actions.AZ.setEnabled(true);
				Actions.RANGE.setEnabled(true);
			}
		}
	}

	public void reFocus() {
		inFocus.requestFocusInWindow();
	}

	public AbstractArgumentList getList1() {
		return arglist1;
	}

	public AbstractArgumentList getList2() {
		return arglist2;
	}

	public TemplateText getInput() {
		return in;
	}

	public OutputText getOutput() {
		return out;
	}

	private static MainFrame instance = null;

	public static MainFrame getI() {
		return instance;
	}

	public MainFrame() {
		instance = this;

		Container content = this.getContentPane();
		content.setLayout(new BorderLayout());

		this.setIconImage(Resources.ICON_REPLICATOR.getImage());

		JSplitPane zero = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		this.arglist1 = new ArgumentList1(this);
		this.arglist2 = new ArgumentList2(this);
		this.in = new TemplateText(this);
		this.out = new OutputText(this);

		this.arglist1.setName("SMART LIST");
		this.arglist2.setName("VERBATIM LIST");
		this.in.setName("TEMPLATE");

		this.arglist1.setToolTipText("SMART LIST");
		this.arglist2.setToolTipText("VERBATIM LIST");
		this.in.setToolTipText("TEMPLATE: text to be replicated");
		this.out.setToolTipText("OUTPUT: left-click to copy all");

		zero.add(new InOutPanel(in, out));
		zero.add(new ListPanel(arglist1, arglist2));
		zero.setResizeWeight(1);
		content.add(zero, BorderLayout.CENTER);
		content.add(statusBar = new StatusBar(), BorderLayout.SOUTH);

		ToolBar toolbar = new ToolBar();
		this.getContentPane().add(toolbar, BorderLayout.PAGE_START);

		Font font = new Font("Courier New", Font.PLAIN, 14);
		this.setGlobalFont(font);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle(TITLE);
		in.requestFocusInWindow();
		inFocus = arglist1;
		this.setFocusedOne(in);
		this.setFocusTraversalPolicy(new MyFocusTraversalPolicy(this, in,
				arglist1, arglist2));
	}

	// TODO: make button for this
	public void clowerArgumentLists() {
		List<String> p1 = Text.parseLines(arglist1.getText());
		Text.clowerList(p1);
		String n1 = Text.mergeList(p1);
		if (!n1.equals(arglist1.getText())) {
			arglist1.setText(n1);
		}

		List<String> p2 = Text.parseLines(arglist2.getText());
		Text.clowerList(p2);
		String n2 = Text.mergeList(p2);
		if (!n2.equals(arglist2.getText())) {
			arglist2.setText(n2);
		}
	}

	// TODO: move all time calculations to PeriodicTimer
	long timestamp = 0;

	public void tick() {
		// wait 2 seconds after last edit
		if (System.currentTimeMillis() - timestamp > 2000) {
			// convert list1 to c_lower case
			String a1 = arglist1.getText();
			if (Text.hasUpperCase(a1)) {
				List<String> p1 = Text.parseLines(a1);
				Text.clowerList(p1);
				int dot = arglist1.getCaret().getDot();
				arglist1.setText(Text.mergeList(p1));
				arglist1.getCaret().setDot(dot);
			}
		}
	}

	private String[] getSmartList() {
		List<String> slist = Text.parseLines(arglist1.getText());
		if (slist == null) {
			return null;
		} else {
			return slist.toArray(new String[0]);
		}
	}

	private String[] getVerbatimList() {
		List<String> slist = Text.parseLines(arglist2.getText());
		if (slist == null) {
			return null;
		} else {
			return slist.toArray(new String[0]);
		}
	}

	public void replicate() {
		timestamp = System.currentTimeMillis();

		int problem1 = XXX.replicator.setSmartList(getSmartList());
		if (problem1 != 0) {
			setMessage("PROBLEM: " + XXX.replicator.getMessage(problem1));
		}

		int problem2 = XXX.replicator.setVerbatimList(getVerbatimList());
		if (problem1 == 0 && problem2 != 0) {
			setMessage("PROBLEM: " + XXX.replicator.getMessage(problem2));
		}

		int problem3 = XXX.replicator.setInput(in.getText());
		in.recalculateStyles(); // <<-----<<
		in.repaint(); // <<-----<<
		if ((problem1 + problem2) == 0 && problem3 != 0) {
			setMessage("PROBLEM: " + XXX.replicator.getMessage(problem3));
		}

		out.setText(XXX.replicator.replicate());
		if (problem1 + problem2 + problem3 == 0) {
			setMessage(XXX.replicator.getFinalMessage());
		}
	}

	public void az() {
		setMessage("generate list of characters");
		DialogAZ.display(this, (AbstractArgumentList) inFocus);
	}

	public void range() {
		setMessage("generate list of integers");
		DialogRange.display(this, (AbstractArgumentList) inFocus);
	}

	public void setGlobalFont(Font font) {
		in.setFont(font);
		out.setFont(font);
		arglist1.setFont(font);
		arglist2.setFont(font);
		statusBar.setFont(font);
	}

	public void help() {
		setMessage("visit site to get documentation or new version");
		AboutDialog.display(this);
	}

	public void incFont() {
		Font font = in.getFont();
		// font size must be float value
		float newSize = font.getSize() + 2.0f;
		font = font.deriveFont(newSize);
		setGlobalFont(font);
		setMessage("font size " + newSize);
	}

	public void decFont() {
		Font font = in.getFont();
		// font size must be float value
		float newSize = Math.max(8.0f, font.getSize() - 2.0f);
		font = font.deriveFont(newSize);
		setGlobalFont(font);
		setMessage("font size " + newSize);
	}

	public void setMessage(String msg) {
		statusBar.setMessage(msg);
	}

}
