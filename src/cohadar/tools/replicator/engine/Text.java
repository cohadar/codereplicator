package cohadar.tools.replicator.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * String manipulation functions
 * */
public class Text {
	public static String UNDERSCORE = "_";
	public static char VOID = '\u7A7A'; // 空

	/**
	 * Extracts argument list from string.
	 * */
	public static List<String> parseLines(String text) {
		List<String> varList = new ArrayList<String>();

		if (text == null) {
			return varList;
		}

		BufferedReader in = null;
		try {
			in = new BufferedReader(new StringReader(text));
			String String;
			while ((String = in.readLine()) != null) {
				varList.add(new String(String));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return varList;
	}

	public static String mergeList(List<String> list) {
		StringBuilder res = new StringBuilder();
		for (String s : list) {
			res.append(s);
			res.append('\n');
		}
		return res.toString();
	}

	// merge parts of string, add separator only in between, not at the end.
	public static String merge(String[] parts, String separator) {
		if (parts == null || parts.length < 1) {
			throw new IllegalArgumentException("parts cannot be null or empty");
		}
		StringBuilder ret = new StringBuilder();
		if ((separator == null) || (separator.length() == 0)) {
			for (String s : parts) {
				ret.append(s);
			}
		} else {
			for (int i = 0; i < parts.length; i++) {
				ret.append(parts[i]);
				if (i != parts.length - 1) {
					ret.append(separator);
				}
			}
		}
		return ret.toString();
	}

	// transform identifier into C-style lower case form
	public static String clowerCase(String s) {
		if (s.contains(UNDERSCORE)) {
			return s.toLowerCase();
		} else {
			StringBuilder ret = new StringBuilder();
			boolean lower = false;
			// when case goes from lower to upper insert underscore
			for (int i = 0; i < s.length(); i++) {
				if (Character.isUpperCase(s.charAt(i))) {
					if (lower) {
						ret.append(UNDERSCORE);
					}
					lower = false;
					ret.append(Character.toLowerCase(s.charAt(i)));
				} else {
					lower = true;
					ret.append(s.charAt(i));
				}
			}
			return ret.toString();
		}
	}

	// transform identifier into C-style lower case form
	public static void clowerList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String arg = list.get(i);
			String clower = Text.clowerCase(arg);
			list.set(i, clower);
		}
	}

	// returns regular expression for finding patterns in input
	static String regExp(String clower, int maxSeparatorLength) {
		if ((clower == null) || clower.length() < 1) {
			throw new IllegalArgumentException(
					"smart argument cannot be null or empty");
		}
		if (!clower.equals(clowerCase(clower))) {
			throw new IllegalArgumentException(
					"smart argument must be in c_lower case");
		}
		if (maxSeparatorLength < 0) {
			throw new IllegalArgumentException(
					"maxSeparatorLength argument cannot be negative");
		}

		String[] parts = literalSplit(clower, UNDERSCORE);
		StringBuilder ret = new StringBuilder();
		ret.append(parts[0]);
		if (parts.length > 1) {
			// first separator
			ret.append(String.format("(.{0,%d}?)", maxSeparatorLength));
			ret.append(parts[1]);
			for (int i = 2; i < parts.length; i++) {
				// next separators must be equal to first
				ret.append("\\1");
				ret.append(parts[i]);
			}
		}
		return ret.toString();
	}

	public static String[] literalSplit(String text, String separator) {
		if (Text.isNotEmpty(separator)) {
			return Pattern.compile(separator, Pattern.LITERAL).split(text);
		} else {
			String[] ret = new String[1];
			ret[0] = text;
			return ret;
		}
	}

	public static String fill(char c, int length) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < length; i++) {
			res.append(c);
		}
		return res.toString();
	}

	public static boolean isEmpty(String text) {
		return !isNotEmpty(text);
	}

	public static boolean isNotEmpty(String text) {
		if (text == null) {
			return false;
		}
		if (text.length() == 0) {
			return false;
		}
		return true;
	}

	public static boolean hasUpperCase(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}
