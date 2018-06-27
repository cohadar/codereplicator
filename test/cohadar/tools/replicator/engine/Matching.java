package cohadar.tools.replicator.engine;

import java.util.regex.Matcher;

import static org.junit.Assert.*;
import org.junit.Test;

public class Matching {
	private CompositeMatcher combo = new CompositeMatcher();
	static String va01 = "rAb b1_t";
	static String in01 = "xxx" + va01 + "yyyy" + va01 + "zzz";

	static String sa02 = "one_two";
	static String in02 = "x" + sa02 + "yy" + sa02.toUpperCase();


	@Test
	public void testSmartMatcher() {
		combo.setSmartList(new String[] {sa02});
		combo.setInput(in02);
		Matcher sm = combo.getSmartMatcher();

		sm.find();
		assertEquals(1, sm.start());
		assertEquals(8, sm.end());
		assertEquals(sa02, sm.group());

		sm.find();
		assertEquals(10, sm.start());
		assertEquals(17, sm.end());
		assertEquals(sa02.toUpperCase(), sm.group());
	}
}
