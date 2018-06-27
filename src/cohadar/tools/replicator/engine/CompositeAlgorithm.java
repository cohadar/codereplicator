package cohadar.tools.replicator.engine;

import java.util.regex.Pattern;

/**
 * call order:
 *   setSmartList
 *   setVerbatimList
 * */
public class CompositeAlgorithm extends Composite {
	protected final int MAX_SEPARATOR_LENGTH = 5;

	protected String[] smartList;
	protected String[] verbatimList;
	protected Pattern smartPattern;
	protected Pattern verbatimPattern;

	public int setSmartList(String[] smartList) {
		this.smartList = null;
		this.smartPattern = null;
		if (smartList == null || smartList.length == 0) {
			return 0;
		}
		if (Text.isBlank(smartList[0])) {
			for (String s : smartList) {
				if (!Text.isBlank(s)) {
					return Composite.BLANK_SMART;
				}
			}
		} else {
			for (int i = 0; i < smartList.length; i++) {
				smartList[i] = Text.clowerCase(smartList[i]);
			}

			if (smartList[0].contains(Text.UNDERSCORE) == false) {
				for (String s : smartList) {
					if (s.contains(Text.UNDERSCORE)) {
						return Composite.UNDERSCORES;
					}
				}
			}

			String regexp = Text.regExp(smartList[0], MAX_SEPARATOR_LENGTH);
			this.smartPattern = Pattern.compile(regexp,
					Pattern.CASE_INSENSITIVE);
			this.smartList = smartList;
		}
		return 0;
	}

	public int setVerbatimList(String[] verbatimList) {
		this.verbatimList = null;
		this.verbatimPattern = null;
		if (verbatimList == null || verbatimList.length == 0) {
			return 0;
		}
		if (Text.isBlank(verbatimList[0])) {
			for (String s : verbatimList) {
				if (!Text.isBlank(s)) {
					return Composite.BLANK_VERBATIM;
				}
			}
		} else {
			this.verbatimList = verbatimList;
			this.verbatimPattern = Pattern.compile(verbatimList[0],
					Pattern.LITERAL);
		}
		return 0;
	}

}
