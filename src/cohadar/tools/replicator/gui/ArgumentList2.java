package cohadar.tools.replicator.gui;

import javax.swing.text.EditorKit;

import cohadar.tools.replicator.gui.components.ListSyntaxKit;

public class ArgumentList2 extends AbstractArgumentList {
	public ArgumentList2(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected EditorKit createDefaultEditorKit() {
		return new ListSyntaxKit(2);
	}
}
