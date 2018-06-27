package cohadar.tools.replicator;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon {
	public MyIcon(URL url) {
		super(url);
	}

	public MyIcon(Image image) {
		super(image);
	}

	public MyIcon to(int x) {
		Image im = this.getImage();
		return new MyIcon(im.getScaledInstance(x, x, Image.SCALE_SMOOTH));
	}
	
	public MyIcon small() {
		Image im = this.getImage();
		return new MyIcon(im.getScaledInstance(24, 24, Image.SCALE_SMOOTH));
	}

}
