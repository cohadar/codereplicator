package cohadar.tools.replicator.gui.components;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.LineMetrics;

import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicLabelUI;

public class UnderlinedLabelUI extends BasicLabelUI {
	public static UnderlinedLabelUI instance = new UnderlinedLabelUI();

	private UnderlinedLabelUI() {
	}

	@Override
	protected void paintDisabledText(JLabel l, Graphics g, String s, int textX,
			int textY) {
		super.paintDisabledText(l, g, s, textX, textY);
		paintUnderline(l, g, s, textX, textY);
	}

	@Override
	protected void paintEnabledText(JLabel l, Graphics g, String s, int textX,
			int textY) {
		super.paintEnabledText(l, g, s, textX, textY);
		paintUnderline(l, g, s, textX, textY);
	}

	private void paintUnderline(JLabel l, Graphics g, String s, int textX,
			int textY) {
		String linkText = l.getText();
		if (linkText != null && linkText.length() > 0) {
			FontMetrics fm = l.getFontMetrics(l.getFont());
			LineMetrics lm = fm.getLineMetrics(s, g);
			int linkWidth = fm.stringWidth(linkText);
			double baseline = textY + Math.ceil(lm.getUnderlineOffset());
			if (linkWidth > 0) {
				// color of line is set by super.paintDisabledText or
				// super.paintEnabledText
				g.drawLine(textX, (int) baseline, textX + linkWidth,
						(int) baseline);
			}
		}
	}

}
