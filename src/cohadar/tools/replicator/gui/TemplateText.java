package cohadar.tools.replicator.gui;

import javax.swing.text.EditorKit;

import cohadar.swing.text.SyntaxDocument;
import cohadar.tools.replicator.gui.components.SharedPalette;
import cohadar.tools.replicator.gui.components.TemplateSyntaxKit;

public class TemplateText extends AbstractTextTarget {

	public TemplateText(MainFrame mainFrame) {
		super(mainFrame, 10, 80);
		SharedPalette.setDefaultSyntaxStyle(getDefaultStyle());
	}

	@Override
	protected EditorKit createDefaultEditorKit() {
		return new TemplateSyntaxKit();
	}

	public void recalculateStyles() {
		((SyntaxDocument) this.getDocument()).recalculateStyles();
	}

}
