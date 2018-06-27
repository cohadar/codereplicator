package cohadar.tools.replicator.engine;

/**
 * call order:
 *   setSmartList
 *   setVerbatimList
 *   setInput
 *   replicate
 * */
public class CompositeReplicator extends CompositeMatcher {
	private static String BSL = "";
	private static String BVL = "";

	private int getSmartSize() {
		if (smartList == null) {
			return 0;
		} else {
			return smartList.length;
		}
	}

	private int getVerbatimSize() {
		if (verbatimList == null) {
			return 0;
		} else {
			return verbatimList.length;
		}
	}

	private int getBiggerSize() {
		int s = getSmartSize();
		int v = getVerbatimSize();
		return Math.max(s, v);
	}

	private int getCommonSize() {
		int s = getSmartSize();
		int v = getVerbatimSize();
		return Math.min(s, v);
	}

	private String getSmart(int index) {
		try {
			return smartList[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			return BSL;
		}
	}

	private String getVerbatim(int index) {
		try {
			return verbatimList[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			return BVL;
		}
	}

	public String replicate() {
		if (input == null || input.length() == 0) {
			return "";
		}

		boolean s = this.smartMatcher != null;
		boolean v = this.verbatimMatcher != null;

		if ((s || v) == false) {
			int n = getBiggerSize();
			finalMessage = String.format("replicated(%d * plain-copy)", n);
			return plainReplicate(input, n);
		}

		if (s && v) {
			int n = getCommonSize();
			int b = getBiggerSize();
			if (b == n) {
				finalMessage = String.format("replicated(%d * combined)", n);
			} else {
				finalMessage = String.format(
						"replicated(%d * combined), ignored %d unpaired", n, b
								- n);
			}
			return combinedReplicate(template.toString(), n);
		}

		if (s) {
			int n = getSmartSize();
			if (n == 0) {
				return "";
			}
			if (n == 1) {
				return input;
			}
			finalMessage = String.format("replicated(%d * smart-replace)", n);
			return smartReplicate(template.toString(), n);
		}

		if (v) {
			int n = getVerbatimSize();
			if (n == 0) {
				return "";
			}
			if (n == 1) {
				return input;
			}
			finalMessage = String
					.format("replicated(%d * verbatim-replace)", n);
			return verbatimReplicate(input, n);
		}

		return "";
	}

	public String combinedReplicate(String in, int n) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			// second list verbatim replacement
			String temp = in.replace(getVerbatim(0), getVerbatim(i));

			// first list smart replacement
			char marker = Text.VOID;
			for (MatchData md : mada) {
				String param = Text.fill(marker, md.getEnd() - md.getStart());
				// TODO: test without getArgument
				String smart = getSmart(i);
				Transform t = md.getTransform();
				smart = t.apply(smart);
				temp = temp.replace(param, smart);
				marker++;
			}
			res.append(temp);
			res.append('\n');
		}
		return res.toString();
	}

	public String smartReplicate(String in, int n) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String temp = in;
			// first list smart replacement
			char marker = Text.VOID;
			for (MatchData md : mada) {
				String param = Text.fill(marker, md.getEnd() - md.getStart());
				// TODO: test without getArgument
				String smart = getSmart(i);
				Transform t = md.getTransform();
				smart = t.apply(smart);
				temp = temp.replace(param, smart);
				marker++;
			}
			res.append(temp);
			res.append('\n');
		}
		return res.toString();
	}

	public String verbatimReplicate(String in, int n) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			res.append(in.replace(getVerbatim(0), getVerbatim(i)));
			res.append('\n');
		}
		return res.toString();
	}

	public String plainReplicate(String in, int n) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			res.append(in);
			res.append('\n');
		}
		return res.toString();
	}

	private String finalMessage;

	public String getFinalMessage() {
		return finalMessage;
	}
}
