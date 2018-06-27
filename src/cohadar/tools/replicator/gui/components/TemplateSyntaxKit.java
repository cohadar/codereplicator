package cohadar.tools.replicator.gui.components;

import java.util.regex.Matcher;

import cohadar.swing.text.AbstractSyntaxKit;
import cohadar.swing.text.SyntaxDocument;
import cohadar.swing.text.SyntaxStyle;
import cohadar.tools.replicator.gui.XXX;

public class TemplateSyntaxKit extends AbstractSyntaxKit {

	@Override
	public void recalculateStyles(SyntaxDocument doc) {
		doc.fillWithStyleIndex(0);
		mm(doc, XXX.replicator.getSmartMatcher(), 1);
		mm(doc, XXX.replicator.getVerbatimMatcher(), 2);
	}

	private void mm(SyntaxDocument doc, Matcher m, int style) {
		if (m != null) {
			m.reset();
			while (m.find()) {
				for (int i = m.start(); i < m.end(); i++) {
					doc.setStyleIndex(i, style);
				}
			}
		}
	}

	@Override
	public String getContentType() {
		return "replicator-template/text";
	}

	@Override
	public SyntaxStyle[] getSyntaxStyles() {
		return SharedPalette.get();
	}

}
