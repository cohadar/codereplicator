package cohadar.tools.replicator.engine;

public class Composite {
	private static String[] text = new String[20];
	public static int OK = 0;
	public static int BLANK_SMART = 1;
	public static int UNDERSCORES = 2;
	public static int BLANK_VERBATIM = 3;
	public static int NO_MATCH_SMART = 4;
	public static int NO_MATCH_VERBATIM = 5;

	static {
		text[OK] = "All Ok";
		text[BLANK_SMART] = "smart list ignored: blank first line";
		text[UNDERSCORES] = "smart list ignored: need underscore(s) on first line";
		text[BLANK_VERBATIM] = "verbatim list ignored: blank first line";
		text[NO_MATCH_SMART] = "smart argument [%s] has no match in template";
		text[NO_MATCH_VERBATIM] = "verbatim argument [%s] has no match in template";
	}

	public String getMessage(int problem) {
		return text[problem];
	}
}
