package cohadar.tools.replicator.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * call order:
 *   setSmartList
 *   setVerbatimList
 *   setInput
 * */
public class CompositeMatcher extends CompositeAlgorithm {
	protected List<MatchData> mada = new ArrayList<MatchData>();

	protected String input;
	protected StringBuilder template;
	protected Matcher smartMatcher;
	protected Matcher verbatimMatcher;

	@Override
	public String getMessage(int problem) {
		if (problem == Composite.NO_MATCH_SMART) {
			return String.format(super.getMessage(problem),
					this.smartList[0]);
		}
		if (problem == Composite.NO_MATCH_VERBATIM) {
			return String.format(super.getMessage(problem),
					this.verbatimList[0]);
		}
		return super.getMessage(problem);
	}

	public int setInput(String input) {
		this.input = input;
		this.smartMatcher = null;
		this.verbatimMatcher = null;
		int problem1 = matchSmart();
		int problem2 = matchVerbatim();
		if (problem1 != 0) {
			return problem1;
		}
		return problem2;
	}

	private int matchSmart() {
		if (input == null) {
			template = null;
			return 0;
		} else {
			template = new StringBuilder(input);
		}
		if (smartPattern == null) {
			return 0;
		}
		smartMatcher = smartPattern.matcher(input);
		// using obscure kanji character for marking matches inside template
		char marker = Text.VOID;
		mada.clear();
		boolean smartHasMatch = false;
		while (smartMatcher.find()) {
			smartHasMatch = true;
			String separator = null;
			// groupCount starts from 1, group(0) is full match
			if (smartMatcher.groupCount() >= 1) {
				separator = smartMatcher.group(1);
			}
			MatchData md = new MatchData(smartMatcher.start(),
					smartMatcher.end(), smartMatcher.group(), separator);

			// TODO: is there a block operation for this?
			for (int i = smartMatcher.start(); i < smartMatcher.end(); i++) {
				template.setCharAt(i, marker);
			}
			mada.add(md);
			marker++;
		}
		if (smartHasMatch == false) {
			smartMatcher = null;
			return Composite.NO_MATCH_SMART;
		}
		return 0;
	}

	// must be called after matchSmart
	private int matchVerbatim() {
		if ((template == null)) {
			return 0;
		}
		if (verbatimPattern == null) {
			return 0;
		}
		verbatimMatcher = verbatimPattern.matcher(template);
		if (verbatimMatcher.find() == false) {
			verbatimMatcher = null;
			return Composite.NO_MATCH_VERBATIM;
		}
		return 0;
	}

	public Matcher getSmartMatcher() {
		if (smartMatcher == null) {
			return null;
		} else {
			smartMatcher.reset();
			return smartMatcher;
		}
	}

	public Matcher getVerbatimMatcher() {
		if (verbatimMatcher == null) {
			return null;
		} else {
			verbatimMatcher.reset();
			return verbatimMatcher;
		}
	}
}
