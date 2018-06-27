package cohadar.tools.replicator.gui.components;

import java.awt.Color;
import java.awt.Font;

import cohadar.swing.text.SyntaxStyle;

public class SharedPalette {
	private static SyntaxStyle[] palette;
	
	public static SyntaxStyle[] get(){
		if (palette == null){
			palette = new SyntaxStyle[3];
			// palette[0] will be set externally to default font color
			palette[1] = new SyntaxStyle(Color.RED, Font.PLAIN);
			palette[2] = new SyntaxStyle(Color.BLUE, Font.PLAIN);
		}
		return palette;
	}
	
	public static void setDefaultSyntaxStyle(SyntaxStyle def){
		palette[0] = def;
	}
}
