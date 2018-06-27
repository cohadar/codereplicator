package cohadar.tools.replicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Resources {

	public static final String PATH_REPLICATOR = "icons/replicator.png";
	
	public static final String PATH_UNDO = "icons/edit-undo.png";
	public static final String PATH_REDO = "icons/edit-redo.png";

	public static final String PATH_CUT = "icons/edit-cut.png";
	public static final String PATH_COPY = "icons/edit-copy.png";
	public static final String PATH_PASTE = "icons/edit-paste.png";
	public static final String PATH_DELETE = "icons/edit-delete.png";
	public static final String PATH_SELECT_ALL = "icons/edit-select-all.png";
	
	public static final String PATH_COPY_ALL = "icons/edit-copy-all.png";
	public static final String PATH_COPY_BLOCK = "icons/edit-copy-block.png";

	public static final String PATH_INC_FONT = "icons/list-add.png";
	public static final String PATH_DEC_FONT = "icons/list-remove.png";
	
	public static final String PATH_HELP = "icons/help-browser.png";

	public static final String PATH_LIST1 = "text/list1.txt";
	public static final String PATH_LIST2 = "text/list2.txt";
	public static final String PATH_INPUT = "text/input.txt";
	

	public static MyIcon ICON_REPLICATOR;

	public static MyIcon ICON_CUT;
	public static MyIcon ICON_COPY;
	public static MyIcon ICON_PASTE;
	public static MyIcon ICON_DELETE;
	public static MyIcon ICON_SELECT_ALL;
	
	public static MyIcon ICON_COPY_ALL;
	public static MyIcon ICON_COPY_BLOCK;

	public static MyIcon ICON_INC_FONT;
	public static MyIcon ICON_DEC_FONT;
	
	public static MyIcon ICON_UNDO;
	public static MyIcon ICON_REDO;

	public static MyIcon ICON_AZ;
	public static MyIcon ICON_RANGE;
	
	public static MyIcon ICON_HELP;

	public static String TEXT_LIST1;
	public static String TEXT_LIST2;
	public static String TEXT_INPUT;

	private static ClassLoader classLoader;

	private static MyIcon loadIcon(String path) {
		URL url = classLoader.getResource(path);
		if (url == null) {
			System.err.println("Icon not found: " + path);
			return null;
		} else {
			return new MyIcon(url);
		}
	}

	public static String loadText(String s) {
		InputStream is = null;
		BufferedReader br = null;
		StringBuilder ret = new StringBuilder();
		try {
			is = classLoader.getResourceAsStream(s);
			br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while (null != (line = br.readLine())) {
				ret.append(line);
				ret.append('\n');
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret.toString();
	}

	// create one instance of this class in your main class
	public Resources() {
		classLoader = getClass().getClassLoader();
		ICON_REPLICATOR = loadIcon(PATH_REPLICATOR);

		ICON_CUT = loadIcon(PATH_CUT);
		ICON_COPY = loadIcon(PATH_COPY);
		ICON_PASTE = loadIcon(PATH_PASTE);
		ICON_DELETE = loadIcon(PATH_DELETE);
		ICON_SELECT_ALL = loadIcon(PATH_SELECT_ALL);
		
		ICON_COPY_ALL = loadIcon(PATH_COPY_ALL);
		ICON_COPY_BLOCK = loadIcon(PATH_COPY_BLOCK);

		ICON_INC_FONT = loadIcon(PATH_INC_FONT);
		ICON_DEC_FONT = loadIcon(PATH_DEC_FONT);
		
		ICON_UNDO = loadIcon(PATH_UNDO);
		ICON_REDO = loadIcon(PATH_REDO);
		ICON_HELP = loadIcon(PATH_HELP);

		TEXT_LIST1 = loadText(PATH_LIST1);
		TEXT_LIST2 = loadText(PATH_LIST2);
		TEXT_INPUT = loadText(PATH_INPUT);
	}

}
