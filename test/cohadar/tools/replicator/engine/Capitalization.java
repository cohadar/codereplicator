package cohadar.tools.replicator.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Capitalization {
	static String l001 = "one_two_three"; // C-style lowercase
	static String u001 = "ONE_TWO_THREE"; // C-style uppercase
	static String c001 = "oneTwoThree"; // camel case
	static String p001 = "OneTwoThree"; // pascal case

	String ret = null;

	@Test
	public void testClowerCase() {
		ret = Text.clowerCase(l001);
		assertEquals(l001, ret);

		ret = Text.clowerCase(u001);
		assertEquals(l001, ret);

		ret = Text.clowerCase(c001);
		assertEquals(l001, ret);

		ret = Text.clowerCase(p001);
		assertEquals(l001, ret);
	}

}
