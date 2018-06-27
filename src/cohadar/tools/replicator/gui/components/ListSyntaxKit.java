package cohadar.tools.replicator.gui.components;

import javax.swing.text.BadLocationException;

import cohadar.swing.text.AbstractSyntaxKit;
import cohadar.swing.text.SyntaxDocument;
import cohadar.swing.text.SyntaxStyle;

public class ListSyntaxKit extends AbstractSyntaxKit {
	
	// style index of first line of text
	private final int styleIndex;

	public ListSyntaxKit(int styleIndex) {
		this.styleIndex = styleIndex;
	}

	@Override
	public SyntaxStyle[] getSyntaxStyles() {
		return SharedPalette.get();
	}
	
	@Override
	public void recalculateStyles(SyntaxDocument doc) {
		doc.fillWithStyleIndex(0);
		try {
			// mark first line of text (argument) in different style
			int end = doc.getLineEndOffset(0);
			for (int i=0; i<end; i++){
				doc.setStyleIndex(i, styleIndex);
			}
		} catch (BadLocationException e) {
		}
	}

	@Override
	public String getContentType() {
		return "replicator-list/text";
	}

}
